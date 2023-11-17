package com.search.dandan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author caiyunfan
 * @since 2023-11-17 13:32:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResourceListElement {
    private String Title;
    private Integer TypeId;
    private String TypeName;
    private Integer SubgroupId;
    private String SubgroupName;
    private String Magnet;
    private String PageUrl;
    private String FileSize;
    private String PublishDate;
}
