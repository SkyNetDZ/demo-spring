package com.example.demo.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "airports")
public class Airport {

    public String id;
    public String ident;
    public String type;
    public String name;
    public String isoCountry;
    public String isoRegion;
    public List<Runway> runways;

    public Airport(final String id,final String ident, final String type,final String name, final String isoCountry, final String isoRegion , final List<Runway> runways) {
        this.id = id;
        this.ident = ident;
        this.type = type;
        this.name = name;
        this.isoCountry = isoCountry;
        this.isoRegion = isoRegion;
        this.runways = runways;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsoCountry() {
        return isoCountry;
    }

    public void setIsoCountry(String isoCountry) {
        this.isoCountry = isoCountry;
    }

    public String getIsoRegion() {
        return isoRegion;
    }

    public void setIsoRegion(String isoRegion) {
        this.isoRegion = isoRegion;
    }

    public List<Runway> getRunways() {
        return runways;
    }

    public void setRunways(List<Runway> runways) {
        this.runways = runways;
    }
}
