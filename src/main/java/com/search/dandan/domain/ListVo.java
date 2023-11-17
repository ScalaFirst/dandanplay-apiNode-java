package com.search.dandan.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author caiyunfan
 * @since 2023-11-17 13:36:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListVo {

    @JsonProperty("HasMore")
    private boolean hasMore;

    @JsonProperty("Resources")
    private List<ResourceListElement> resources;

    public boolean getHasMore() {
        return hasMore;
    }

    public boolean isHasMore() {
        return hasMore;
    }
}
