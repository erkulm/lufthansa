
package com.erkul.reactive.demo.external.model.seatmap;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "SeatAvailabilityResource"
})
@Generated("jsonschema2pojo")
public class SeatMapResponse {

    @JsonProperty("SeatAvailabilityResource")
    private SeatAvailabilityResource seatAvailabilityResource;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("SeatAvailabilityResource")
    public SeatAvailabilityResource getSeatAvailabilityResource() {
        return seatAvailabilityResource;
    }

    @JsonProperty("SeatAvailabilityResource")
    public void setSeatAvailabilityResource(SeatAvailabilityResource seatAvailabilityResource) {
        this.seatAvailabilityResource = seatAvailabilityResource;
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
