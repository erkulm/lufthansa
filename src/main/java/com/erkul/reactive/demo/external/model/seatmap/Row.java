
package com.erkul.reactive.demo.external.model.seatmap;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Position",
        "Orientation"
})
@Generated("jsonschema2pojo")
public class Row {

    @JsonProperty("Position")
    private String position;
    @JsonProperty("Orientation")
    private Orientation orientation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Position")
    public String getPosition() {
        return position;
    }

    @JsonProperty("Position")
    public void setPosition(String position) {
        this.position = position;
    }

    @JsonProperty("Orientation")
    public Orientation getOrientation() {
        return orientation;
    }

    @JsonProperty("Orientation")
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
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
