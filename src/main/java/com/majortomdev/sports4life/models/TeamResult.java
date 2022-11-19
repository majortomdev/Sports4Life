package com.majortomdev.sports4life.models;

public class TeamResult {

    private int seasonId;
    private int leagueId;
    private String name;
    private int position;
    private int points;
    private int wins;
    private int losses;
    private int draws;
    private int goalDiff;

    public TeamResult(int seasonId, int leagueId, String name, int position,
                      int points, int wins, int losses, int draws, int goalDiff) {
        this.seasonId = seasonId;
        this.leagueId = leagueId;
        this.name = name;
        this.position = position;
        this.points = points;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.goalDiff = goalDiff;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getGoalDiff() {
        return goalDiff;
    }

    public void setGoalDiff(int goalDiff) {
        this.goalDiff = goalDiff;
    }
}
