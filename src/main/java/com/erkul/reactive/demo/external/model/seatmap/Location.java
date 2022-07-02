
package com.erkul.reactive.demo.external.model.seatmap;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Row",
        "Column",
        "Type"
})
@Generated("jsonschema2pojo")
public class Location {

    @JsonProperty("Row")
    private Row row;
    @JsonProperty("Column")
    private Column__1 column;
    @JsonProperty("Type")
    private Type type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Row")
    public Row getRow() {
        return row;
    }

    @JsonProperty("Row")
    public void setRow(Row row) {
        this.row = row;
    }

    @JsonProperty("Column")
    public Column__1 getColumn() {
        return column;
    }

    @JsonProperty("Column")
    public void setColumn(Column__1 column) {
        this.column = column;
    }

    @JsonProperty("Type")
    public Type getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(Type type) {
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
