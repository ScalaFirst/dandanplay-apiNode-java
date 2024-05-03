package com.search.dandan.service.impl;

import com.search.dandan.domain.*;
import com.search.dandan.enums.AcgnxType;
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
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AcgnxService implements SearchService {

    private static final Logger log = LoggerFactory.getLogger(AcgnxService.class);
    private static final String acgnxBaseUri = "https://share.acgnx.net";
    private static final String acgnxSearchUri = acgnxBaseUri + "/%s.xml?keyword=%s";

    private static final DateTimeFormatter format = DateTimeFormat.forPattern("EEE, dd MMM yyyy HH:mm:ss Z").withLocale(Locale.ENGLISH);

    @Override
    public ListVo getListPage(String keyword, String subgroup, String type, String r, int page) throws IOException {
        AcgnxType acgnxType = AcgnxType.DM;
        try {
            int typeId = Integer.parseInt(type);
            AcgnxType tmp = AcgnxType.fromTypeId(typeId);
            if(tmp != null){
                acgnxType = tmp;
            }
        } catch (NumberFormatException ignored) {}

        String url = String.format(acgnxSearchUri,acgnxType.getRssName(),keyword);
        log.info(url);
        Document document = Jsoup.connect(url).get();

        List<ResourceListElement> elements = new ArrayList<>();
        ListVo listVo = new ListVo(false,elements);

        for (Element item : document.select("item")) {
            Element title = item.selectFirst("title");
            Element category = item.selectFirst("category");
            AcgnxType aType = category != null && category.text().trim().contains("季度全集") ? AcgnxType.JDQJ : AcgnxType.DM;
            Element enclosure = item.selectFirst("enclosure");
            String magnet = enclosure != null ? enclosure.attr("url") : "";
            Element description = item.selectFirst("description");
            String fileSize = description != null ? description.text().trim().split("\\|")[2].trim() : "0B";
            Element pubDate = item.selectFirst("pubDate");
            String pubTime = pubDate != null ? format.parseDateTime(pubDate.text().trim()).toString("yyyy-MM-dd HH:mm:ss") : "";

            ResourceListElement element = new ResourceListElement(
                    title != null ? title.text().trim() : "未知标题",
                    aType.getId(),
                    aType.getName(),
                    0,
                    "未知字幕组",
                    magnet,
                    url,
                    fileSize,
                    pubTime
            );
            elements.add(element);
        }

        return listVo;
    }

    @Override
    public SubgroupVO getSubgroup(){
        return new SubgroupVO(Collections.emptyList());
    }

    @Override
    public TypeVO getType(){
        return new TypeVO(Arrays.stream(AcgnxType.values()).map(a-> new ListElement(a.getId(),a.getName())).collect(Collectors.toList()));
    }
}
