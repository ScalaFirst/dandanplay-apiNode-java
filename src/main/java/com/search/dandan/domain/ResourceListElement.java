package com.search.dandan.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("Title")
    private String title;

    @JsonProperty("TypeId")
    private Integer typeId;

    @JsonProperty("TypeName")
    private String typeName;

    @JsonProperty("SubgroupId")
    private Integer subgroupId;

    @JsonProperty("SubgroupName")
    private String subgroupName;

    @JsonProperty("Magnet")
    private String magnet;

    @JsonProperty("PageUrl")
    private String pageUrl;

    @JsonProperty("FileSize")
    private String fileSize;

    @JsonProperty("PublishDate")
    private String publishDate;
}
