
package com.erkul.reactive.demo.external.model.seatmap;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Columns",
        "Rows",
        "Component",
        "CabinType"
})
@Generated("jsonschema2pojo")
public class SeatDisplay {

    @JsonProperty("Columns")
    private List<Column> columns = null;
    @JsonProperty("Rows")
    private Rows__2 rows;
    @JsonProperty("Component")
    private List<Component> component = null;
    @JsonProperty("CabinType")
    private CabinType cabinType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Columns")
    public List<Column> getColumns() {
        return columns;
    }

    @JsonProperty("Columns")
    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    @JsonProperty("Rows")
    public Rows__2 getRows() {
        return rows;
    }

    @JsonProperty("Rows")
    public void setRows(Rows__2 rows) {
        this.rows = rows;
    }

    @JsonProperty("Component")
    public List<Component> getComponent() {
        return component;
    }

    @JsonProperty("Component")
    public void setComponent(List<Component> component) {
        this.component = component;
    }

    @JsonProperty("CabinType")
    public CabinType getCabinType() {
        return cabinType;
    }

    @JsonProperty("CabinType")
    public void setCabinType(CabinType cabinType) {
        this.cabinType = cabinType;
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
