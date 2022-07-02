
package com.erkul.reactive.demo.external.model.seatmap;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Flights",
        "CabinLayout",
        "SeatDisplay",
        "SeatDetails",
        "Meta"
})
@Generated("jsonschema2pojo")
public class SeatAvailabilityResource {

    @JsonProperty("Flights")
    private Flights flights;
    @JsonProperty("CabinLayout")
    private CabinLayout cabinLayout;
    @JsonProperty("SeatDisplay")
    private SeatDisplay seatDisplay;
    @JsonProperty("SeatDetails")
    private List<SeatDetail> seatDetails = null;
    @JsonProperty("Meta")
    private Meta meta;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Flights")
    public Flights getFlights() {
        return flights;
    }

    @JsonProperty("Flights")
    public void setFlights(Flights flights) {
        this.flights = flights;
    }

    @JsonProperty("CabinLayout")
    public CabinLayout getCabinLayout() {
        return cabinLayout;
    }

    @JsonProperty("CabinLayout")
    public void setCabinLayout(CabinLayout cabinLayout) {
        this.cabinLayout = cabinLayout;
    }

    @JsonProperty("SeatDisplay")
    public SeatDisplay getSeatDisplay() {
        return seatDisplay;
    }

    @JsonProperty("SeatDisplay")
    public void setSeatDisplay(SeatDisplay seatDisplay) {
        this.seatDisplay = seatDisplay;
    }

    @JsonProperty("SeatDetails")
    public List<SeatDetail> getSeatDetails() {
        return seatDetails;
    }

    @JsonProperty("SeatDetails")
    public void setSeatDetails(List<SeatDetail> seatDetails) {
        this.seatDetails = seatDetails;
    }

    @JsonProperty("Meta")
    public Meta getMeta() {
        return meta;
    }

    @JsonProperty("Meta")
    public void setMeta(Meta meta) {
        this.meta = meta;
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
