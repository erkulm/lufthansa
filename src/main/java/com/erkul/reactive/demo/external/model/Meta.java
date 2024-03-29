
package com.erkul.reactive.demo.external.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "@Version",
    "Link",
    "TotalCount"
})
@Generated("jsonschema2pojo")
public class Meta {

    @JsonProperty("@Version")
    private String version;
    @JsonProperty("Link")
    private List<Link> link = new ArrayList<Link>();
    @JsonProperty("TotalCount")
    private Integer totalCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("@Version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("@Version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("Link")
    public List<Link> getLink() {
        return link;
    }

    @JsonProperty("Link")
    public void setLink(List<Link> link) {
        this.link = link;
    }

    @JsonProperty("TotalCount")
    public Integer getTotalCount() {
        return totalCount;
    }

    @JsonProperty("TotalCount")
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
