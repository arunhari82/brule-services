package com.brule.models;

import java.util.Objects;

public class DMNResponse {
    private boolean generated;
    private String dmnXML;


    public DMNResponse() {
    }

    public DMNResponse(boolean generated, String dmnXML) {
        this.generated = generated;
        this.dmnXML = dmnXML;
    }

    public boolean isGenerated() {
        return this.generated;
    }

    public boolean getGenerated() {
        return this.generated;
    }

    public void setGenerated(boolean generated) {
        this.generated = generated;
    }

    public String getDmnXML() {
        return this.dmnXML;
    }

    public void setDmnXML(String dmnXML) {
        this.dmnXML = dmnXML;
    }

    public DMNResponse generated(boolean generated) {
        setGenerated(generated);
        return this;
    }

    public DMNResponse dmnXML(String dmnXML) {
        setDmnXML(dmnXML);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DMNResponse)) {
            return false;
        }
        DMNResponse dMNResponse = (DMNResponse) o;
        return generated == dMNResponse.generated && Objects.equals(dmnXML, dMNResponse.dmnXML);
    }

    @Override
    public int hashCode() {
        return Objects.hash(generated, dmnXML);
    }

    @Override
    public String toString() {
        return "{" +
            " generated='" + isGenerated() + "'" +
            ", dmnXML='" + getDmnXML() + "'" +
            "}";
    }



}
