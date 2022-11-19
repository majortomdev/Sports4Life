package com.majortomdev.sports4life.models;

public class SeasonStats {

    private int played;
    private int wins;
    private int draws;
    private int losses;
    private int goalDiff;
    private int goalsFor;
    private int goalsAgainst;

    public SeasonStats(int played, int wins, int draws, int losses, int goalDiff, int goalsFor, int goalsAgainst) {
        this.played = played;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
        this.goalDiff = goalDiff;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getGoalDiff() {
        return goalDiff;
    }

    public void setGoalDiff(int goalDiff) {
        this.goalDiff = goalDiff;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }


}
