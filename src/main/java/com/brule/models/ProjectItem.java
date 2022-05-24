package com.brule.models;

import java.util.Objects;

public class ProjectItem {
    
    private String name;
    private String value;


    public ProjectItem() {
    }

    public ProjectItem(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ProjectItem name(String name) {
        setName(name);
        return this;
    }

    public ProjectItem value(String value) {
        setValue(value);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProjectItem)) {
            return false;
        }
        ProjectItem projectItem = (ProjectItem) o;
        return Objects.equals(name, projectItem.name) && Objects.equals(value, projectItem.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", value='" + getValue() + "'" +
            "}";
    }

}
