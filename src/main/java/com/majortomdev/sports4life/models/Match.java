package com.majortomdev.sports4life.models;

public class Match {

    private int matchId;
    private int round;
    private int homeId;
    private int awayId;
    private String score;
    private String halfTimeScore;

    public Match () {

    }

    public Match(int matchId, int round, int homeId, int awayId,
                 String score, String halfTimeScore) {
        this.matchId = matchId;
        this.round = round;
        this.homeId = homeId;
        this.awayId = awayId;
        this.score = score;
        this.halfTimeScore = halfTimeScore;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    public int getAwayId() {
        return awayId;
    }

    public void setAwayId(int awayId) {
        this.awayId = awayId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getHalfTimeScore() {
        return halfTimeScore;
    }

    public void setHalfTimeScore(String halfTimeScore) {
        this.halfTimeScore = halfTimeScore;
    }
}
