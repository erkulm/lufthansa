
package com.erkul.reactive.demo.external.model;

import java.util.HashMap;
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
    "@Href",
    "@Rel"
})
@Generated("jsonschema2pojo")
public class Link {

    @JsonProperty("@Href")
    private String href;
    @JsonProperty("@Rel")
    private String rel;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("@Href")
    public String getHref() {
        return href;
    }

    @JsonProperty("@Href")
    public void setHref(String href) {
        this.href = href;
    }

    public Link withHref(String href) {
        this.href = href;
        return this;
    }

    @JsonProperty("@Rel")
    public String getRel() {
        return rel;
    }

    @JsonProperty("@Rel")
    public void setRel(String rel) {
        this.rel = rel;
    }

    public Link withRel(String rel) {
        this.rel = rel;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Link withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
