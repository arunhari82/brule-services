package com.brule.models.datamodels;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "drl",
        "schemaList"
})
@Generated("jsonschema2pojo")
public class SchemaGroup {

    @JsonProperty("drl")
    private String drl;
    @JsonProperty("schemaList")
    private List<Schema> schemaList = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("drl")
    public String getDrl() {
        return drl;
    }

    @JsonProperty("drl")
    public void setDrl(String drl) {
        this.drl = drl;
    }

    @JsonProperty("schemaList")
    public List<Schema> getSchemaList() {
        return schemaList;
    }

    @JsonProperty("schemaList")
    public void setSchemaList(List<Schema> schemaList) {
        this.schemaList = schemaList;
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