package com.example.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Country {
    public String id ;
    public String name;
    public String code ;
    public String continent;


    public Country(String id, String name, String code, String continent) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.continent = continent;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
