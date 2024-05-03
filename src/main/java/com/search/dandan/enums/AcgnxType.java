package com.search.dandan.enums;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum AcgnxType {
    DM(1,"動畫"),
    JDQJ(2,"季度全集");

    private final Integer id;
    private final String name;
    private final String rssName;

    AcgnxType(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.rssName = "rss-sort-" + id;
    }

    public static AcgnxType fromTypeId(Integer id){
        for (AcgnxType value : values()) {
            if(Objects.equals(value.id, id)){
                return value;
            }
        }
        return null;
    }
}
