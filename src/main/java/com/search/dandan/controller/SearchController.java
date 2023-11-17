package com.search.dandan.controller;

import com.search.dandan.domain.ListVo;
import com.search.dandan.domain.SubgroupVO;
import com.search.dandan.domain.TypeVO;
import com.search.dandan.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author caiyunfan
 * @since 2023-11-17 11:11:00
 */

@RestController
public class SearchController {

    @Autowired
    SearchService searchShareDmhyService;

    @GetMapping("/")
    public Map<String, String> readRoot() {
        Map<String, String> response = new HashMap<>();
        response.put("Hello", "World");
        return response;
    }


    @GetMapping("/list")
    public ListVo listPage(@RequestParam("keyword") String keyword,
                           @RequestParam(value = "subgroup", required = false) String subgroup,
                           @RequestParam(value = "type", required = false) String type,
                           @RequestParam(value = "r", required = false) String r,
                           @RequestParam(value = "page", defaultValue = "1") int page) throws IOException {
        return searchShareDmhyService.getListPage(keyword, subgroup, type, r, page);
    }

    @GetMapping("/subgroup")
    public SubgroupVO subgroup() throws IOException {
        return searchShareDmhyService.getSubgroup();
    }

    @GetMapping("/type")
    public TypeVO type() throws IOException {
        return searchShareDmhyService.getType();
    }

}
