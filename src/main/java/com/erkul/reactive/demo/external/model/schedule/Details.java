
package com.erkul.reactive.demo.external.model.schedule;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Stops",
        "DaysOfOperation",
        "DatePeriod"
})
@Generated("jsonschema2pojo")
public class Details {

    @JsonProperty("Stops")
    private Stops stops;
    @JsonProperty("DaysOfOperation")
    private String daysOfOperation;
    @JsonProperty("DatePeriod")
    private DatePeriod datePeriod;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Stops")
    public Stops getStops() {
        return stops;
    }

    @JsonProperty("Stops")
    public void setStops(Stops stops) {
        this.stops = stops;
    }

    @JsonProperty("DaysOfOperation")
    public String getDaysOfOperation() {
        return daysOfOperation;
    }

    @JsonProperty("DaysOfOperation")
    public void setDaysOfOperation(String daysOfOperation) {
        this.daysOfOperation = daysOfOperation;
    }

    @JsonProperty("DatePeriod")
    public DatePeriod getDatePeriod() {
        return datePeriod;
    }

    @JsonProperty("DatePeriod")
    public void setDatePeriod(DatePeriod datePeriod) {
        this.datePeriod = datePeriod;
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
