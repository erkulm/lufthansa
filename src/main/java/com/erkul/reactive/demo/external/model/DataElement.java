
package com.erkul.reactive.demo.external.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "startLegSequenceNumber",
        "endLegSequenceNumber",
        "id",
        "value"
})
@Generated("jsonschema2pojo")
public class DataElement {

    @JsonProperty("startLegSequenceNumber")
    private Integer startLegSequenceNumber;
    @JsonProperty("endLegSequenceNumber")
    private Integer endLegSequenceNumber;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("startLegSequenceNumber")
    public Integer getStartLegSequenceNumber() {
        return startLegSequenceNumber;
    }

    @JsonProperty("startLegSequenceNumber")
    public void setStartLegSequenceNumber(Integer startLegSequenceNumber) {
        this.startLegSequenceNumber = startLegSequenceNumber;
    }

    @JsonProperty("endLegSequenceNumber")
    public Integer getEndLegSequenceNumber() {
        return endLegSequenceNumber;
    }

    @JsonProperty("endLegSequenceNumber")
    public void setEndLegSequenceNumber(Integer endLegSequenceNumber) {
        this.endLegSequenceNumber = endLegSequenceNumber;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
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
