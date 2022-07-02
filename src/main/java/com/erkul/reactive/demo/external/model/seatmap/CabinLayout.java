
package com.erkul.reactive.demo.external.model.seatmap;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "WingPosition",
        "ExitRowPosition"
})
@Generated("jsonschema2pojo")
public class CabinLayout {

    @JsonProperty("WingPosition")
    private WingPosition wingPosition;
    @JsonProperty("ExitRowPosition")
    private ExitRowPosition exitRowPosition;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("WingPosition")
    public WingPosition getWingPosition() {
        return wingPosition;
    }

    @JsonProperty("WingPosition")
    public void setWingPosition(WingPosition wingPosition) {
        this.wingPosition = wingPosition;
    }

    @JsonProperty("ExitRowPosition")
    public ExitRowPosition getExitRowPosition() {
        return exitRowPosition;
    }

    @JsonProperty("ExitRowPosition")
    public void setExitRowPosition(ExitRowPosition exitRowPosition) {
        this.exitRowPosition = exitRowPosition;
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
