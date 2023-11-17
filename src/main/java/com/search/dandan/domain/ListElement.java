package com.search.dandan.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author caiyunfan
 * @since 2023-11-17 11:31:00
 */
@AllArgsConstructor
@NoArgsConstructor
public class ListElement {
    private Integer Id;
    private String Name;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
