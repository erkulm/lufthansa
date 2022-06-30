
package com.erkul.reactive.demo.external.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "sequenceNumber",
        "origin",
        "destination",
        "serviceType",
        "aircraftOwner",
        "aircraftType",
        "aircraftConfigurationVersion",
        "registration",
        "op",
        "aircraftDepartureTimeUTC",
        "aircraftDepartureTimeDateDiffUTC",
        "aircraftDepartureTimeLT",
        "aircraftDepartureTimeDateDiffLT",
        "aircraftDepartureTimeVariation",
        "aircraftArrivalTimeUTC",
        "aircraftArrivalTimeDateDiffUTC",
        "aircraftArrivalTimeLT",
        "aircraftArrivalTimeDateDiffLT",
        "aircraftArrivalTimeVariation"
})
@Generated("jsonschema2pojo")
public class Leg {

    @JsonProperty("sequenceNumber")
    private Integer sequenceNumber;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("destination")
    private String destination;
    @JsonProperty("serviceType")
    private String serviceType;
    @JsonProperty("aircraftOwner")
    private String aircraftOwner;
    @JsonProperty("aircraftType")
    private String aircraftType;
    @JsonProperty("aircraftConfigurationVersion")
    private String aircraftConfigurationVersion;
    @JsonProperty("registration")
    private String registration;
    @JsonProperty("op")
    private Boolean op;
    @JsonProperty("aircraftDepartureTimeUTC")
    private Integer aircraftDepartureTimeUTC;
    @JsonProperty("aircraftDepartureTimeDateDiffUTC")
    private Integer aircraftDepartureTimeDateDiffUTC;
    @JsonProperty("aircraftDepartureTimeLT")
    private Integer aircraftDepartureTimeLT;
    @JsonProperty("aircraftDepartureTimeDateDiffLT")
    private Integer aircraftDepartureTimeDateDiffLT;
    @JsonProperty("aircraftDepartureTimeVariation")
    private Integer aircraftDepartureTimeVariation;
    @JsonProperty("aircraftArrivalTimeUTC")
    private Integer aircraftArrivalTimeUTC;
    @JsonProperty("aircraftArrivalTimeDateDiffUTC")
    private Integer aircraftArrivalTimeDateDiffUTC;
    @JsonProperty("aircraftArrivalTimeLT")
    private Integer aircraftArrivalTimeLT;
    @JsonProperty("aircraftArrivalTimeDateDiffLT")
    private Integer aircraftArrivalTimeDateDiffLT;
    @JsonProperty("aircraftArrivalTimeVariation")
    private Integer aircraftArrivalTimeVariation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("sequenceNumber")
    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    @JsonProperty("sequenceNumber")
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    @JsonProperty("origin")
    public String getOrigin() {
        return origin;
    }

    @JsonProperty("origin")
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @JsonProperty("destination")
    public String getDestination() {
        return destination;
    }

    @JsonProperty("destination")
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @JsonProperty("serviceType")
    public String getServiceType() {
        return serviceType;
    }

    @JsonProperty("serviceType")
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @JsonProperty("aircraftOwner")
    public String getAircraftOwner() {
        return aircraftOwner;
    }

    @JsonProperty("aircraftOwner")
    public void setAircraftOwner(String aircraftOwner) {
        this.aircraftOwner = aircraftOwner;
    }

    @JsonProperty("aircraftType")
    public String getAircraftType() {
        return aircraftType;
    }

    @JsonProperty("aircraftType")
    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    @JsonProperty("aircraftConfigurationVersion")
    public String getAircraftConfigurationVersion() {
        return aircraftConfigurationVersion;
    }

    @JsonProperty("aircraftConfigurationVersion")
    public void setAircraftConfigurationVersion(String aircraftConfigurationVersion) {
        this.aircraftConfigurationVersion = aircraftConfigurationVersion;
    }

    @JsonProperty("registration")
    public String getRegistration() {
        return registration;
    }

    @JsonProperty("registration")
    public void setRegistration(String registration) {
        this.registration = registration;
    }

    @JsonProperty("op")
    public Boolean getOp() {
        return op;
    }

    @JsonProperty("op")
    public void setOp(Boolean op) {
        this.op = op;
    }

    @JsonProperty("aircraftDepartureTimeUTC")
    public Integer getAircraftDepartureTimeUTC() {
        return aircraftDepartureTimeUTC;
    }

    @JsonProperty("aircraftDepartureTimeUTC")
    public void setAircraftDepartureTimeUTC(Integer aircraftDepartureTimeUTC) {
        this.aircraftDepartureTimeUTC = aircraftDepartureTimeUTC;
    }

    @JsonProperty("aircraftDepartureTimeDateDiffUTC")
    public Integer getAircraftDepartureTimeDateDiffUTC() {
        return aircraftDepartureTimeDateDiffUTC;
    }

    @JsonProperty("aircraftDepartureTimeDateDiffUTC")
    public void setAircraftDepartureTimeDateDiffUTC(Integer aircraftDepartureTimeDateDiffUTC) {
        this.aircraftDepartureTimeDateDiffUTC = aircraftDepartureTimeDateDiffUTC;
    }

    @JsonProperty("aircraftDepartureTimeLT")
    public Integer getAircraftDepartureTimeLT() {
        return aircraftDepartureTimeLT;
    }

    @JsonProperty("aircraftDepartureTimeLT")
    public void setAircraftDepartureTimeLT(Integer aircraftDepartureTimeLT) {
        this.aircraftDepartureTimeLT = aircraftDepartureTimeLT;
    }

    @JsonProperty("aircraftDepartureTimeDateDiffLT")
    public Integer getAircraftDepartureTimeDateDiffLT() {
        return aircraftDepartureTimeDateDiffLT;
    }

    @JsonProperty("aircraftDepartureTimeDateDiffLT")
    public void setAircraftDepartureTimeDateDiffLT(Integer aircraftDepartureTimeDateDiffLT) {
        this.aircraftDepartureTimeDateDiffLT = aircraftDepartureTimeDateDiffLT;
    }

    @JsonProperty("aircraftDepartureTimeVariation")
    public Integer getAircraftDepartureTimeVariation() {
        return aircraftDepartureTimeVariation;
    }

    @JsonProperty("aircraftDepartureTimeVariation")
    public void setAircraftDepartureTimeVariation(Integer aircraftDepartureTimeVariation) {
        this.aircraftDepartureTimeVariation = aircraftDepartureTimeVariation;
    }

    @JsonProperty("aircraftArrivalTimeUTC")
    public Integer getAircraftArrivalTimeUTC() {
        return aircraftArrivalTimeUTC;
    }

    @JsonProperty("aircraftArrivalTimeUTC")
    public void setAircraftArrivalTimeUTC(Integer aircraftArrivalTimeUTC) {
        this.aircraftArrivalTimeUTC = aircraftArrivalTimeUTC;
    }

    @JsonProperty("aircraftArrivalTimeDateDiffUTC")
    public Integer getAircraftArrivalTimeDateDiffUTC() {
        return aircraftArrivalTimeDateDiffUTC;
    }

    @JsonProperty("aircraftArrivalTimeDateDiffUTC")
    public void setAircraftArrivalTimeDateDiffUTC(Integer aircraftArrivalTimeDateDiffUTC) {
        this.aircraftArrivalTimeDateDiffUTC = aircraftArrivalTimeDateDiffUTC;
    }

    @JsonProperty("aircraftArrivalTimeLT")
    public Integer getAircraftArrivalTimeLT() {
        return aircraftArrivalTimeLT;
    }

    @JsonProperty("aircraftArrivalTimeLT")
    public void setAircraftArrivalTimeLT(Integer aircraftArrivalTimeLT) {
        this.aircraftArrivalTimeLT = aircraftArrivalTimeLT;
    }

    @JsonProperty("aircraftArrivalTimeDateDiffLT")
    public Integer getAircraftArrivalTimeDateDiffLT() {
        return aircraftArrivalTimeDateDiffLT;
    }

    @JsonProperty("aircraftArrivalTimeDateDiffLT")
    public void setAircraftArrivalTimeDateDiffLT(Integer aircraftArrivalTimeDateDiffLT) {
        this.aircraftArrivalTimeDateDiffLT = aircraftArrivalTimeDateDiffLT;
    }

    @JsonProperty("aircraftArrivalTimeVariation")
    public Integer getAircraftArrivalTimeVariation() {
        return aircraftArrivalTimeVariation;
    }

    @JsonProperty("aircraftArrivalTimeVariation")
    public void setAircraftArrivalTimeVariation(Integer aircraftArrivalTimeVariation) {
        this.aircraftArrivalTimeVariation = aircraftArrivalTimeVariation;
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
