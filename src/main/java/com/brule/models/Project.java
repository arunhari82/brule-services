package com.brule.models;

import java.util.HashMap;
import java.util.Objects;
import java.util.ArrayList;

public class Project {
    
    private String name;
    private String version;
    private String companyName;
    private ArrayList<ProjectItem> rulebooks;
    private ArrayList<ProjectItem> models;


    public Project() {
    }

    public Project(String name, String version, String companyName, ArrayList<ProjectItem> rulebooks, ArrayList<ProjectItem> models) {
        this.name = name;
        this.version = version;
        this.companyName = companyName;
        this.rulebooks = rulebooks;
        this.models = models;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public ArrayList<ProjectItem> getRulebooks() {
        return this.rulebooks;
    }

    public void setRulebooks(ArrayList<ProjectItem> rulebooks) {
        this.rulebooks = rulebooks;
    }

    public ArrayList<ProjectItem> getModels() {
        return this.models;
    }

    public void setModels(ArrayList<ProjectItem> models) {
        this.models = models;
    }

    public Project name(String name) {
        setName(name);
        return this;
    }

    public Project version(String version) {
        setVersion(version);
        return this;
    }

    public Project companyName(String companyName) {
        setCompanyName(companyName);
        return this;
    }

    public Project rulebooks(ArrayList<ProjectItem> rulebooks) {
        setRulebooks(rulebooks);
        return this;
    }

    public Project models(ArrayList<ProjectItem> models) {
        setModels(models);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Project)) {
            return false;
        }
        Project project = (Project) o;
        return Objects.equals(name, project.name) && Objects.equals(version, project.version) && Objects.equals(companyName, project.companyName) && Objects.equals(rulebooks, project.rulebooks) && Objects.equals(models, project.models);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, version, companyName, rulebooks, models);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", version='" + getVersion() + "'" +
            ", companyName='" + getCompanyName() + "'" +
            ", rulebooks='" + getRulebooks() + "'" +
            ", models='" + getModels() + "'" +
            "}";
    }

   
}
