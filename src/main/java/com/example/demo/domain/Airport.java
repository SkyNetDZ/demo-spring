package com.example.demo.domain;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "airports")
public class Airport {

    public String id;
    public String ident;
    public String type;
    public String name;
    @Indexed
    @Field("iso_country")
    public String isoCountry;
    @Field("iso_region")
    public String isoRegion;
    public List<Runway> runways;

    public Airport(String id, String ident, String type, String name, String isoCountry, String isoRegion) {
        this.id = id;
        this.ident = ident;
        this.type = type;
        this.name = name;
        this.isoCountry = isoCountry;
        this.isoRegion = isoRegion;
        this.runways = new ArrayList<Runway>();
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

    public void addRunway(Runway runway) {
        this.runways.add(runway);
    }
}
