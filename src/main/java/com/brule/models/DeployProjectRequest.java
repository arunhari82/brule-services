package com.brule.models;
import java.util.Objects;

public class DeployProjectRequest {

    private String projectName;
    private int portno;


    public DeployProjectRequest() {
    }

    public DeployProjectRequest(String projectName, int portno) {
        this.projectName = projectName;
        this.portno = portno;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getPortno() {
        return this.portno;
    }

    public void setPortno(int portno) {
        this.portno = portno;
    }

    public DeployProjectRequest projectName(String projectName) {
        setProjectName(projectName);
        return this;
    }

    public DeployProjectRequest portno(int portno) {
        setPortno(portno);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DeployProjectRequest)) {
            return false;
        }
        DeployProjectRequest deployProjectRequest = (DeployProjectRequest) o;
        return Objects.equals(projectName, deployProjectRequest.projectName) && portno == deployProjectRequest.portno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName, portno);
    }

    @Override
    public String toString() {
        return "{" +
            " projectName='" + getProjectName() + "'" +
            ", portno='" + getPortno() + "'" +
            "}";
    }

    
}
