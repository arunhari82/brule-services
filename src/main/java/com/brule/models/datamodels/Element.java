package com.brule.models.datamodels;

import java.util.HashMap;
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
        "name",
        "datatype",
        "isList",
        "nodeid"
})
@Generated("jsonschema2pojo")
public class Element {

    @JsonProperty("name")
    private String name;
    @JsonProperty("datatype")
    private String datatype;
    @JsonProperty("isList")
    private Boolean isList;
    @JsonProperty("nodeid")
    private Integer nodeid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("datatype")
    public String getDatatype() {
        return datatype;
    }

    @JsonProperty("datatype")
    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    @JsonProperty("isList")
    public Boolean getIsList() {
        return isList;
    }

    @JsonProperty("isList")
    public void setIsList(Boolean isList) {
        this.isList = isList;
    }

    @JsonProperty("nodeid")
    public Integer getNodeid() {
        return nodeid;
    }

    @JsonProperty("nodeid")
    public void setNodeid(Integer nodeid) {
        this.nodeid = nodeid;
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