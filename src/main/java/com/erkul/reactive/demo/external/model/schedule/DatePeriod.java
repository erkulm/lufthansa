
package com.erkul.reactive.demo.external.model.schedule;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Effective",
        "Expiration"
})
@Generated("jsonschema2pojo")
public class DatePeriod {

    @JsonProperty("Effective")
    private String effective;
    @JsonProperty("Expiration")
    private String expiration;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Effective")
    public String getEffective() {
        return effective;
    }

    @JsonProperty("Effective")
    public void setEffective(String effective) {
        this.effective = effective;
    }

    @JsonProperty("Expiration")
    public String getExpiration() {
        return expiration;
    }

    @JsonProperty("Expiration")
    public void setExpiration(String expiration) {
        this.expiration = expiration;
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
