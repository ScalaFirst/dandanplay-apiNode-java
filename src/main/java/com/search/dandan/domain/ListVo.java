package com.search.dandan.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author caiyunfan
 * @since 2023-11-17 13:36:00
 */
@AllArgsConstructor
@NoArgsConstructor
public class ListVo {
    private boolean HasMore;
    private List<ResourceListElement> Resources;

    public boolean getHasMore() {
        return HasMore;
    }

    public boolean isHasMore() {
        return HasMore;
    }

    public void setHasMore(boolean hasMore) {
        HasMore = hasMore;
    }

    public List<ResourceListElement> getResources() {
        return Resources;
    }

    public void setResources(List<ResourceListElement> resources) {
        Resources = resources;
    }
}
