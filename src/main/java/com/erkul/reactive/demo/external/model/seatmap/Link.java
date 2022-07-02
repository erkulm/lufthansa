
package com.erkul.reactive.demo.external.model.seatmap;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

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

    @JsonProperty("@Rel")
    public String getRel() {
        return rel;
    }

    @JsonProperty("@Rel")
    public void setRel(String rel) {
        this.rel = rel;
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
