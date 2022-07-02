
package com.erkul.reactive.demo.external.model.seatmap;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Number",
        "Characteristics",
        "Type"
})
@Generated("jsonschema2pojo")
public class Row__1 {

    @JsonProperty("Number")
    private String number;
    @JsonProperty("Characteristics")
    private Characteristics characteristics;
    @JsonProperty("Type")
    private Type__1 type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Number")
    public String getNumber() {
        return number;
    }

    @JsonProperty("Number")
    public void setNumber(String number) {
        this.number = number;
    }

    @JsonProperty("Characteristics")
    public Characteristics getCharacteristics() {
        return characteristics;
    }

    @JsonProperty("Characteristics")
    public void setCharacteristics(Characteristics characteristics) {
        this.characteristics = characteristics;
    }

    @JsonProperty("Type")
    public Type__1 getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(Type__1 type) {
        this.type = type;
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
