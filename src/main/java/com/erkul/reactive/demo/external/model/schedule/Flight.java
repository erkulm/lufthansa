
package com.erkul.reactive.demo.external.model.schedule;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Departure",
        "Arrival",
        "MarketingCarrier",
        "OperatingCarrier",
        "Equipment",
        "Details"
})
@Generated("jsonschema2pojo")
public class Flight {

    @JsonProperty("Departure")
    private Departure departure;
    @JsonProperty("Arrival")
    private Arrival arrival;
    @JsonProperty("MarketingCarrier")
    private MarketingCarrier marketingCarrier;
    @JsonProperty("OperatingCarrier")
    private OperatingCarrier operatingCarrier;
    @JsonProperty("Equipment")
    private Equipment equipment;
    @JsonProperty("Details")
    private Details details;
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

    @JsonProperty("OperatingCarrier")
    public OperatingCarrier getOperatingCarrier() {
        return operatingCarrier;
    }

    @JsonProperty("OperatingCarrier")
    public void setOperatingCarrier(OperatingCarrier operatingCarrier) {
        this.operatingCarrier = operatingCarrier;
    }

    @JsonProperty("Equipment")
    public Equipment getEquipment() {
        return equipment;
    }

    @JsonProperty("Equipment")
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @JsonProperty("Details")
    public Details getDetails() {
        return details;
    }

    @JsonProperty("Details")
    public void setDetails(Details details) {
        this.details = details;
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
