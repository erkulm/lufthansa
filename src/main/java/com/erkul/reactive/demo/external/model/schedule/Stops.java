
package com.erkul.reactive.demo.external.model.schedule;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "StopQuantity"
})
@Generated("jsonschema2pojo")
public class Stops {

    @JsonProperty("StopQuantity")
    private Integer stopQuantity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("StopQuantity")
    public Integer getStopQuantity() {
        return stopQuantity;
    }

    @JsonProperty("StopQuantity")
    public void setStopQuantity(Integer stopQuantity) {
        this.stopQuantity = stopQuantity;
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
