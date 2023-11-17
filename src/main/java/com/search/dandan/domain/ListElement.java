package com.search.dandan.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author caiyunfan
 * @since 2023-11-17 11:31:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListElement {

    @JsonProperty("Id")
    private Integer id;

    @JsonProperty("Name")
    private String name;
}
