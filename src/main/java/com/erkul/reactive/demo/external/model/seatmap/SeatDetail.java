
package com.erkul.reactive.demo.external.model.seatmap;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Location"
})
@Generated("jsonschema2pojo")
public class SeatDetail {

    @JsonProperty("Location")
    private Location__1 location;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Location")
    public Location__1 getLocation() {
        return location;
    }

    @JsonProperty("Location")
    public void setLocation(Location__1 location) {
        this.location = location;
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
