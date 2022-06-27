
package com.erkul.reactive.demo.external.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "CityCode",
        "CountryCode",
        "Names",
        "UtcOffset",
        "TimeZoneId",
        "Airports"
})
@Generated("jsonschema2pojo")
public class City {

    @JsonProperty("CityCode")
    private String cityCode;
    @JsonProperty("CountryCode")
    private String countryCode;
    @JsonProperty("Names")
    private Names names;
    @JsonProperty("UtcOffset")
    private String utcOffset;
    @JsonProperty("TimeZoneId")
    private String timeZoneId;
    @JsonProperty("Airport")
    private Set<Airport> airports;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("CityCode")
    public String getCityCode() {
        return cityCode;
    }

    @JsonProperty("CityCode")
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public City withCityCode(String cityCode) {
        this.cityCode = cityCode;
        return this;
    }

    @JsonProperty("CountryCode")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("CountryCode")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public City withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    @JsonProperty("Names")
    public Names getNames() {
        return names;
    }

    @JsonProperty("Names")
    public void setNames(Names names) {
        this.names = names;
    }

    public City withNames(Names names) {
        this.names = names;
        return this;
    }

    @JsonProperty("UtcOffset")
    public String getUtcOffset() {
        return utcOffset;
    }

    @JsonProperty("UtcOffset")
    public void setUtcOffset(String utcOffset) {
        this.utcOffset = utcOffset;
    }

    public City withUtcOffset(String utcOffset) {
        this.utcOffset = utcOffset;
        return this;
    }

    @JsonProperty("TimeZoneId")
    public String getTimeZoneId() {
        return timeZoneId;
    }

    @JsonProperty("TimeZoneId")
    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public City withTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
        return this;
    }

    @JsonProperty("Airport")
    public Set<Airport> getAirports() {
        return airports;
    }

    @JsonProperty("Airport")
    public void setAirports(Set<Airport> airports) {
        this.airports = airports;
    }

    public City withAirports(Set<Airport> airports) {
        this.airports = airports;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public City withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
