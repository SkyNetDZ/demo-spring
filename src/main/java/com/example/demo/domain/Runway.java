package com.example.demo.domain;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "runways")
public class Runway {

    public String id;
    public String airportRef;
    public String airportIdent;
    public String lentgthFt;
    public String widthFT;
    public Boolean lighted;
    public Boolean closed;


    public Runway(String id, String airportRef, String airportIdent, String lentgthFt, String widthFT, Boolean lighted, Boolean closed) {
        this.id = id;
        this.airportRef = airportRef;
        this.airportIdent = airportIdent;
        this.lentgthFt = lentgthFt;
        this.widthFT = widthFT;
        this.lighted = lighted;
        this.closed = closed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAirportRef() {
        return airportRef;
    }

    public void setAirportRef(String airportRef) {
        this.airportRef = airportRef;
    }

    public String getAirportIdent() {
        return airportIdent;
    }

    public void setAirportIdent(String airportIdent) {
        this.airportIdent = airportIdent;
    }

    public String getLentgthFt() {
        return lentgthFt;
    }

    public void setLentgthFt(String lentgthFt) {
        this.lentgthFt = lentgthFt;
    }

    public String getWidthFT() {
        return widthFT;
    }

    public void setWidthFT(String widthFT) {
        this.widthFT = widthFT;
    }

    public Boolean getLighted() {
        return lighted;
    }

    public void setLighted(Boolean lighted) {
        this.lighted = lighted;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }
}
