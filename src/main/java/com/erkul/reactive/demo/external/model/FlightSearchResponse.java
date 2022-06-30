
package com.erkul.reactive.demo.external.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "airline",
        "flightNumber",
        "suffix",
        "periodOfOperationUTC",
        "periodOfOperationLT",
        "legs",
        "dataElements"
})
@Generated("jsonschema2pojo")
public class FlightSearchResponse {

    @JsonProperty("airline")
    private String airline;
    @JsonProperty("flightNumber")
    private Integer flightNumber;
    @JsonProperty("suffix")
    private String suffix;
    @JsonProperty("periodOfOperationUTC")
    private PeriodOfOperationUTC periodOfOperationUTC;
    @JsonProperty("periodOfOperationLT")
    private PeriodOfOperationLT periodOfOperationLT;
    @JsonProperty("legs")
    private List<Leg> legs = new ArrayList<Leg>();
    @JsonProperty("dataElements")
    private List<DataElement> dataElements = new ArrayList<DataElement>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("airline")
    public String getAirline() {
        return airline;
    }

    @JsonProperty("airline")
    public void setAirline(String airline) {
        this.airline = airline;
    }

    @JsonProperty("flightNumber")
    public Integer getFlightNumber() {
        return flightNumber;
    }

    @JsonProperty("flightNumber")
    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    @JsonProperty("suffix")
    public String getSuffix() {
        return suffix;
    }

    @JsonProperty("suffix")
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @JsonProperty("periodOfOperationUTC")
    public PeriodOfOperationUTC getPeriodOfOperationUTC() {
        return periodOfOperationUTC;
    }

    @JsonProperty("periodOfOperationUTC")
    public void setPeriodOfOperationUTC(PeriodOfOperationUTC periodOfOperationUTC) {
        this.periodOfOperationUTC = periodOfOperationUTC;
    }

    @JsonProperty("periodOfOperationLT")
    public PeriodOfOperationLT getPeriodOfOperationLT() {
        return periodOfOperationLT;
    }

    @JsonProperty("periodOfOperationLT")
    public void setPeriodOfOperationLT(PeriodOfOperationLT periodOfOperationLT) {
        this.periodOfOperationLT = periodOfOperationLT;
    }

    @JsonProperty("legs")
    public List<Leg> getLegs() {
        return legs;
    }

    @JsonProperty("legs")
    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }

    @JsonProperty("dataElements")
    public List<DataElement> getDataElements() {
        return dataElements;
    }

    @JsonProperty("dataElements")
    public void setDataElements(List<DataElement> dataElements) {
        this.dataElements = dataElements;
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
