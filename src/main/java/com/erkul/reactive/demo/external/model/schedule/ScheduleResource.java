
package com.erkul.reactive.demo.external.model.schedule;

import com.erkul.reactive.demo.external.model.Meta;
import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Schedule",
        "Meta"
})
@Generated("jsonschema2pojo")
public class ScheduleResource {

    @JsonProperty("Schedule")
    private List<Schedule> schedule = null;
    @JsonProperty("Meta")
    private com.erkul.reactive.demo.external.model.Meta meta;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Schedule")
    public List<Schedule> getSchedule() {
        return schedule;
    }

    @JsonProperty("Schedule")
    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }

    @JsonProperty("Meta")
    public com.erkul.reactive.demo.external.model.Meta getMeta() {
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
