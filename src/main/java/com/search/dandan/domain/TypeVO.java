package com.search.dandan.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author caiyunfan
 * @since 2023-11-17 11:29:00
 */
@AllArgsConstructor
@NoArgsConstructor
public class TypeVO {
    private List<ListElement> Types;

    public List<ListElement> getTypes() {
        return Types;
    }

    public void setTypes(List<ListElement> types) {
        Types = types;
    }
}
