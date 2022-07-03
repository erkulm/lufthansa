
package com.erkul.reactive.demo.external.model.schedule;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "AirlineID"
})
@Generated("jsonschema2pojo")
public class OperatingCarrier {

    @JsonProperty("AirlineID")
    private String airlineID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("AirlineID")
    public String getAirlineID() {
        return airlineID;
    }

    @JsonProperty("AirlineID")
    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
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
