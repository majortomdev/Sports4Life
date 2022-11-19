package com.majortomdev.sports4life.models;

public class Venue {

    private int venueId;
    private String name;
    private int capacity;
    private String city;
    private int countryId;

    public Venue(int venueId, String name, int capacity, String city, int countryId) {
        this.venueId = venueId;
        this.name = name;
        this.capacity = capacity;
        this.city = city;
        this.countryId = countryId;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
                return name+"(id= "+venueId+") is in "
                        +city+" and it has a capacity of "+capacity;
    }
}
