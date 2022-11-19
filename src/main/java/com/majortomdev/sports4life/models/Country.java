package com.majortomdev.sports4life.models;

public class Country {
    private int countryId;
    private String name;
    private String countryCode;
    private String continent;

    public Country() {
    }

    public Country(int countryId, String name, String countryCode, String continent) {
        this.countryId = countryId;
        this.name = name;
        this.countryCode = countryCode;
        this.continent = continent;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "This country is "+name + ", with id: "+countryId+". Its country code is "
                +countryCode+ " and it is in "+continent;
    }
}
