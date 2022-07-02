
package com.erkul.reactive.demo.external.model.seatmap;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "First",
        "Last"
})
@Generated("jsonschema2pojo")
public class Rows__2 {

    @JsonProperty("First")
    private String first;
    @JsonProperty("Last")
    private String last;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("First")
    public String getFirst() {
        return first;
    }

    @JsonProperty("First")
    public void setFirst(String first) {
        this.first = first;
    }

    @JsonProperty("Last")
    public String getLast() {
        return last;
    }

    @JsonProperty("Last")
    public void setLast(String last) {
        this.last = last;
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
