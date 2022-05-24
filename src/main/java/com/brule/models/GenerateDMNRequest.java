package com.brule.models;

import java.util.ArrayList;

import com.brule.models.datamodels.Library;
import java.util.Objects;

public class GenerateDMNRequest {
    
   private ArrayList<Library> libraryList;
   


    public GenerateDMNRequest() {
    }

    public GenerateDMNRequest(ArrayList<Library> libraryList) {
        this.libraryList = libraryList;
    }

    public ArrayList<Library> getLibraryList() {
        return this.libraryList;
    }

    public void setLibraryList(ArrayList<Library> libraryList) {
        this.libraryList = libraryList;
    }

    public GenerateDMNRequest libraryList(ArrayList<Library> libraryList) {
        setLibraryList(libraryList);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GenerateDMNRequest)) {
            return false;
        }
        GenerateDMNRequest generateDMNRequest = (GenerateDMNRequest) o;
        return Objects.equals(libraryList, generateDMNRequest.libraryList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(libraryList);
    }

    @Override
    public String toString() {
        return "{" +
            " libraryList='" + getLibraryList() + "'" +
            "}";
    }


}
