package com.search.dandan.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author caiyunfan
 * @since 2023-11-17 11:29:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TypeVO {

    @JsonProperty("Types")
    private List<ListElement> types;
}
