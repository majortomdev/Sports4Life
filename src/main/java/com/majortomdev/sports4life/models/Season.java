package com.majortomdev.sports4life.models;

import java.util.Date;

public class Season {

    private int seasonId;
    private String name;
    private boolean isCurrent;
    private int countryId;
    private int leagueId;
    private Date startDate;
    private Date endDate;

    public Season(int seasonId, String name, boolean isCurrent, int countryId,
                  int leagueId, Date startDate, Date endDate) {
        this.seasonId = seasonId;
        this.name = name;
        this.isCurrent = isCurrent;
        this.countryId = countryId;
        this.leagueId = leagueId;
//        this.startDate = startDate;
//        this.endDate = endDate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setCurrent(boolean current) {
        isCurrent = current;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
