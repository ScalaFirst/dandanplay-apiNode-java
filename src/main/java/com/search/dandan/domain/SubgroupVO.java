package com.search.dandan.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author caiyunfan
 * @since 2023-11-17 11:32:00
 */
@AllArgsConstructor
@NoArgsConstructor
public class SubgroupVO {
    private List<ListElement> Subgroups;

    public List<ListElement> getSubgroups() {
        return Subgroups;
    }

    public void setSubgroups(List<ListElement> subgroups) {
        Subgroups = subgroups;
    }
}
