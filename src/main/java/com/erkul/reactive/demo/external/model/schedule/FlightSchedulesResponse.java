
package com.erkul.reactive.demo.external.model.schedule;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ScheduleResource"
})
@Generated("jsonschema2pojo")
public class FlightSchedulesResponse {

    @JsonProperty("ScheduleResource")
    private ScheduleResource scheduleResource;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ScheduleResource")
    public ScheduleResource getScheduleResource() {
        return scheduleResource;
    }

    @JsonProperty("ScheduleResource")
    public void setScheduleResource(ScheduleResource scheduleResource) {
        this.scheduleResource = scheduleResource;
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
