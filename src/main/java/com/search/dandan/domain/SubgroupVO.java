package com.search.dandan.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author caiyunfan
 * @since 2023-11-17 11:32:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubgroupVO {

    @JsonProperty("Subgroups")
    private List<ListElement> subgroups;
}
