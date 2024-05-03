package com.search.dandan;

import com.search.dandan.controller.SearchController;
import com.search.dandan.domain.ListVo;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Locale;

@SpringBootTest
class DandanSearchApiApplicationTests {
    @Autowired
    private SearchController controller;

    @Test
    void contextLoads() throws IOException {
        ListVo listVo = controller.listPage("美好世界", "", "", "", 1);
        System.out.println(listVo.toString());

    }

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("EEE, dd MMM yyyy HH:mm:ss Z").withLocale(Locale.ENGLISH);
        System.out.println(DateTime.now().toString(formatter));
    }

}
