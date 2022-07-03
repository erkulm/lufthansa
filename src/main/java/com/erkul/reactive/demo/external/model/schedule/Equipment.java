
package com.erkul.reactive.demo.external.model.schedule;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "AircraftCode"
})
@Generated("jsonschema2pojo")
public class Equipment {

    @JsonProperty("AircraftCode")
    private String aircraftCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("AircraftCode")
    public String getAircraftCode() {
        return aircraftCode;
    }

    @JsonProperty("AircraftCode")
    public void setAircraftCode(String aircraftCode) {
        this.aircraftCode = aircraftCode;
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
