package com.majortomdev.sports4life.models;

public class Team {

    int teamId;
    private String name;
    private String shortCode;
    private String commonName;
    private String logo;
    private Country teamCountry;

    public Team() {

    }

    public Team(int teamId, String name, String shortCode, String commonName, String logo, Country country) {
        this.teamId = teamId;
        this.name = name;
        this.shortCode = shortCode;
        this.commonName = commonName;
        this.logo = logo;
        this.teamCountry = country;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Country getTeamCountry() {
        return teamCountry;
    }

    public void setTeamCountry(Country teamCountry) {
        this.teamCountry = teamCountry;
    }
}
