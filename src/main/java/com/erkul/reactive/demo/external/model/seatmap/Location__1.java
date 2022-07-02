
package com.erkul.reactive.demo.external.model.seatmap;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Column",
        "Row"
})
@Generated("jsonschema2pojo")
public class Location__1 {

    @JsonProperty("Column")
    private String column;
    @JsonProperty("Row")
    private Row__1 row;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Column")
    public String getColumn() {
        return column;
    }

    @JsonProperty("Column")
    public void setColumn(String column) {
        this.column = column;
    }

    @JsonProperty("Row")
    public Row__1 getRow() {
        return row;
    }

    @JsonProperty("Row")
    public void setRow(Row__1 row) {
        this.row = row;
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
