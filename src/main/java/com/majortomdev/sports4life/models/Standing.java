package com.majortomdev.sports4life.models;

import java.util.Map;

public class Standing {

    private int teamId;
    private int position;
    private int points;
    private String status;
    private String result;
    private Map<String,SeasonStats> stats;

    public Standing(int teamId, int position, int points, String status, String result, Map<String, SeasonStats> stats) {
        this.teamId = teamId;
        this.position = position;
        this.points = points;
        this.status = status;
        this.result = result;
        this.stats = stats;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map<String, SeasonStats> getStats() {
        return stats;
    }

    public void setStats(Map<String, SeasonStats> stats) {
        this.stats = stats;
    }
}
