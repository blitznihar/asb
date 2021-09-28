package com.blitznihar.queueing.asb.entities;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "restaurant")
public class RestaurantModel implements Serializable{

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }

    private String name;
    private String cuisine;
    private String borough;
    private AddressModel address;

    public RestaurantModel(String name, String cuisine, String borough, AddressModel address) {
        this.name = name;
        this.cuisine = cuisine;
        this.borough = borough;
        this.address = address;
    }
}

