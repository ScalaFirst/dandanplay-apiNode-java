package com.search.dandan.service;

import com.search.dandan.domain.ListVo;
import com.search.dandan.domain.SubgroupVO;
import com.search.dandan.domain.TypeVO;

import java.io.IOException;

/**
 * @author caiyunfan
 * @since 2023-11-17 11:16:00
 */

public interface SearchService {
    ListVo getListPage(String keyword,String subgroup,String type,String r,int page) throws IOException;

    SubgroupVO getSubgroup() throws IOException;

    TypeVO getType() throws IOException;
}
