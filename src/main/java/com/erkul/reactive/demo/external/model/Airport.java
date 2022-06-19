
package com.erkul.reactive.demo.external.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "AirportCode",
    "Position",
    "CityCode",
    "CountryCode",
    "LocationType",
    "Names",
    "UtcOffset",
    "TimeZoneId"
})
@Generated("jsonschema2pojo")
public class Airport {

    @JsonProperty("AirportCode")
    private String airportCode;
    @JsonProperty("Position")
    private Position position;
    @JsonProperty("CityCode")
    private String cityCode;
    @JsonProperty("CountryCode")
    private String countryCode;
    @JsonProperty("LocationType")
    private String locationType;
    @JsonProperty("Names")
    private Names names;
    @JsonProperty("UtcOffset")
    private String utcOffset;
    @JsonProperty("TimeZoneId")
    private String timeZoneId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("AirportCode")
    public String getAirportCode() {
        return airportCode;
    }

    @JsonProperty("AirportCode")
    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    @JsonProperty("Position")
    public Position getPosition() {
        return position;
    }

    @JsonProperty("Position")
    public void setPosition(Position position) {
        this.position = position;
    }

    @JsonProperty("CityCode")
    public String getCityCode() {
        return cityCode;
    }

    @JsonProperty("CityCode")
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @JsonProperty("CountryCode")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("CountryCode")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("LocationType")
    public String getLocationType() {
        return locationType;
    }

    @JsonProperty("LocationType")
    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    @JsonProperty("Names")
    public Names getNames() {
        return names;
    }

    @JsonProperty("Names")
    public void setNames(Names names) {
        this.names = names;
    }

    @JsonProperty("UtcOffset")
    public String getUtcOffset() {
        return utcOffset;
    }

    @JsonProperty("UtcOffset")
    public void setUtcOffset(String utcOffset) {
        this.utcOffset = utcOffset;
    }

    @JsonProperty("TimeZoneId")
    public String getTimeZoneId() {
        return timeZoneId;
    }

    @JsonProperty("TimeZoneId")
    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
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
