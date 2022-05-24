package com.brule.models;

import java.util.Objects;

public class BuildProjectResponse {

    private String projectName;
    private String result;


    public BuildProjectResponse() {
    }

    public BuildProjectResponse(String projectName, String result) {
        this.projectName = projectName;
        this.result = result;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public BuildProjectResponse projectName(String projectName) {
        setProjectName(projectName);
        return this;
    }

    public BuildProjectResponse result(String result) {
        setResult(result);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BuildProjectResponse)) {
            return false;
        }
        BuildProjectResponse buildProjectResponse = (BuildProjectResponse) o;
        return Objects.equals(projectName, buildProjectResponse.projectName) && Objects.equals(result, buildProjectResponse.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName, result);
    }

    @Override
    public String toString() {
        return "{" +
            " projectName='" + getProjectName() + "'" +
            ", result='" + getResult() + "'" +
            "}";
    }

    
}
