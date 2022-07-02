
package com.erkul.reactive.demo.external.model.seatmap;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Departure",
        "Arrival",
        "MarketingCarrier",
        "Equipment"
})
@Generated("jsonschema2pojo")
public class Flight {

    @JsonProperty("Departure")
    private Departure departure;
    @JsonProperty("Arrival")
    private Arrival arrival;
    @JsonProperty("MarketingCarrier")
    private MarketingCarrier marketingCarrier;
    @JsonProperty("Equipment")
    private Equipment equipment;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Departure")
    public Departure getDeparture() {
        return departure;
    }

    @JsonProperty("Departure")
    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    @JsonProperty("Arrival")
    public Arrival getArrival() {
        return arrival;
    }

    @JsonProperty("Arrival")
    public void setArrival(Arrival arrival) {
        this.arrival = arrival;
    }

    @JsonProperty("MarketingCarrier")
    public MarketingCarrier getMarketingCarrier() {
        return marketingCarrier;
    }

    @JsonProperty("MarketingCarrier")
    public void setMarketingCarrier(MarketingCarrier marketingCarrier) {
        this.marketingCarrier = marketingCarrier;
    }

    @JsonProperty("Equipment")
    public Equipment getEquipment() {
        return equipment;
    }

    @JsonProperty("Equipment")
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
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
