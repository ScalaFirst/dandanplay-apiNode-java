package com.search.dandan.service.impl;

import com.search.dandan.domain.*;
import com.search.dandan.service.SearchService;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author caiyunfan
 * @since 2023-11-17 11:17:00
 */
@Service
public class SearchShareDmhyImpl implements SearchService {
    private static final Logger log = LoggerFactory.getLogger(SearchShareDmhyImpl.class);

    private static final String dmhyBaseUri = "https://share.dmhy.org";
    private static final String dmhyTypeAndSubgroupUri = dmhyBaseUri + "/topics/advanced-search?team_id=0&sort_id=0&orderby=";
    private static final String dmhyListUri = dmhyBaseUri + "/topics/list/page/%d?keyword=%s&sort_id=%s&team_id=%s&order=date-desc";
    private static final int unknownSubgroupId = -1;
    private static final String unknownSubgroupName = "未知字幕组";

    private final DateTimeFormatter format = DateTimeFormat.forPattern("yyyy/MM/dd HH:mm");

    private ResourceListElement parseListTr(Element tr) {
        Element td0 = tr.select("td").get(0);
        Element td1 = tr.select("td").get(1);
        Element td2 = tr.select("td").get(2);
        Element td3 = tr.select("td").get(3);
        Element td4 = tr.select("td").get(4);
        int c1 = td2.select("a").size();
        Element td1_a0 = td1.select("a").get(0);
        Element td2_a0 = td2.select("a").get(0);
        Element td2_a_last = td2.select("a").last();
        Element td3_a0 = td3.select("a").get(0);

        String publishDate = td0.select("span").get(0).text().trim();
        return new ResourceListElement(
                td2_a_last == null ? "未知标题" : td2_a_last.text().trim(),
                Integer.parseInt(td1_a0.attr("href").replace("/topics/list/sort_id/", "")),
                td1_a0.text().trim(),
                c1 != 2 ? unknownSubgroupId : Integer.parseInt(td2_a0.attr("href").replace("/topics/list/team_id/", "")),
                c1 != 2 ? unknownSubgroupName : td2_a0.text().trim(),
                td3_a0.attr("href"),
                td2_a_last == null ? "" : dmhyBaseUri + td2_a_last.attr("href"),
                td4.text().trim(),
                format.parseDateTime(publishDate).toString("yyyy-MM-dd HH:mm:ss")
        );
    }

    @Override
    public ListVo getListPage(String keyword, String subgroup, String type, String r, int page) throws IOException {
        String url = String.format(dmhyListUri, page, keyword, type, subgroup);
        log.info(url);
        Document doc = Jsoup.connect(url).get();
        ListVo listVo = new ListVo();
        List<ResourceListElement> elements = new ArrayList<>();
        listVo.setResources(elements);
        for (Element tr : doc.select("table#topic_list tbody tr")) {
            ResourceListElement element = parseListTr(tr);
            elements.add(element);
        }
        boolean hasMore = doc.select("div.nav_title > a:contains('下一頁')").size() > 0;
        listVo.setHasMore(hasMore);
        return listVo;
    }

    @Override
    public SubgroupVO getSubgroup() throws IOException {
        SubgroupVO subgroupVO = new SubgroupVO();
        List<ListElement> elements = new ArrayList<>();
        subgroupVO.setSubgroups(elements);

        Document doc = Jsoup.connect(dmhyTypeAndSubgroupUri).get();
        List<Element> options = doc.select("select#AdvSearchTeam option");
        for (Element option : options) {
            int id = Integer.parseInt(option.attr("value"));
            String name = option.text();
            elements.add(new ListElement(id, name));
        }
        return subgroupVO;
    }

    @Override
    public TypeVO getType() throws IOException {
        TypeVO typeVO = new TypeVO();
        List<ListElement> elements = new ArrayList<>();
        typeVO.setTypes(elements);
        Document doc = Jsoup.connect(dmhyTypeAndSubgroupUri).get();
        List<Element> options = doc.select("select#AdvSearchSort option");
        for (Element option : options) {
            int id = Integer.parseInt(option.attr("value"));
            String name = option.text();
            elements.add(new ListElement(id, name));
        }

        return typeVO;
    }
}
