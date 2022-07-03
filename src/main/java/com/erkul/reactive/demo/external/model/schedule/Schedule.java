
package com.erkul.reactive.demo.external.model.schedule;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "TotalJourney",
        "Flight"
})
@Generated("jsonschema2pojo")
public class Schedule {

    @JsonProperty("TotalJourney")
    private TotalJourney totalJourney;
    @JsonProperty("Flight")
    private List<Flight> flight = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("TotalJourney")
    public TotalJourney getTotalJourney() {
        return totalJourney;
    }

    @JsonProperty("TotalJourney")
    public void setTotalJourney(TotalJourney totalJourney) {
        this.totalJourney = totalJourney;
    }

    @JsonProperty("Flight")
    public List<Flight> getFlight() {
        return flight;
    }

    @JsonProperty("Flight")
    public void setFlight(List<Flight> flight) {
        this.flight = flight;
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
