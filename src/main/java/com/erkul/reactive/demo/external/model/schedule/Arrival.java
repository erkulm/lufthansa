
package com.erkul.reactive.demo.external.model.schedule;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "AirportCode",
        "ScheduledTimeLocal",
        "Terminal"
})
@Generated("jsonschema2pojo")
public class Arrival {

    @JsonProperty("AirportCode")
    private String airportCode;
    @JsonProperty("ScheduledTimeLocal")
    private ScheduledTimeLocal__1 scheduledTimeLocal;
    @JsonProperty("Terminal")
    private Terminal__1 terminal;
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

    @JsonProperty("ScheduledTimeLocal")
    public ScheduledTimeLocal__1 getScheduledTimeLocal() {
        return scheduledTimeLocal;
    }

    @JsonProperty("ScheduledTimeLocal")
    public void setScheduledTimeLocal(ScheduledTimeLocal__1 scheduledTimeLocal) {
        this.scheduledTimeLocal = scheduledTimeLocal;
    }

    @JsonProperty("Terminal")
    public Terminal__1 getTerminal() {
        return terminal;
    }

    @JsonProperty("Terminal")
    public void setTerminal(Terminal__1 terminal) {
        this.terminal = terminal;
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
