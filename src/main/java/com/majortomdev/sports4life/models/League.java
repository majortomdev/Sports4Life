package com.majortomdev.sports4life.models;

public class League {

    private int leagueId;
    private int countryId;
    private String name;

    public League(int leagueId, int countryId, String name) {
        this.leagueId = leagueId;
        this.countryId = countryId;
        this.name = name;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
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

    @Override
    public String toString() {
        return "League info{" +
                "leagueId=" + leagueId +
                ", countryId=" + countryId +
                ", name='" + name + '\'' +
                '}';
    }
}
