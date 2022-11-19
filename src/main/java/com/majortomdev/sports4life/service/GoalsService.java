package com.majortomdev.sports4life.service;

import com.majortomdev.sports4life.models.PlrScoreRecord;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoalsService {

    public List<PlrScoreRecord> getSeasonGoals(String jsonSeasonGoals){
        List<PlrScoreRecord> players = new ArrayList<>();
        JSONObject jsonObj = new JSONObject(jsonSeasonGoals);
        JSONArray goalsArray = jsonObj.getJSONArray("data");

        for(int i=0; i<goalsArray.length(); i++){
            JSONObject jsonPlayerGoals = goalsArray.getJSONObject(i);
            players.add(createPlayerSeasonGoalsInst(jsonPlayerGoals));
        }
        return players;
    }

    public List<PlrScoreRecord> getSeasonTeamGoals(String jsonSeasonGoals, int teamId){
        List<PlrScoreRecord> players = new ArrayList<>();
        JSONObject jsonObj = new JSONObject(jsonSeasonGoals);
        JSONArray goalsArray = jsonObj.getJSONArray("data");
        for(int i=0; i<goalsArray.length(); i++){
            JSONObject jsonPlayerGoals = goalsArray.getJSONObject(i);
            JSONObject innerTeamObj = jsonPlayerGoals.getJSONObject("team");
            if(teamId == (int)innerTeamObj.get("team_id")) {
                players.add(createPlayerSeasonGoalsInst(jsonPlayerGoals));
            }
        }
        return players;
    }

    private PlrScoreRecord createPlayerSeasonGoalsInst(JSONObject goalsScoredObj){
            Object ranking = goalsScoredObj.get("pos");
            JSONObject innerPlayer = goalsScoredObj.getJSONObject("player");
            Object plrId = innerPlayer.get("player_id");
            int playerId;
            if(!JSONObject.NULL.equals(plrId)){
                playerId = (int) plrId;
            }else playerId = -1;
            JSONObject innerTeam = goalsScoredObj.getJSONObject("team");
            Object teamId = innerTeam.get("team_id");
            Object leagueId = goalsScoredObj.get("league_id");
            Object seasonId = goalsScoredObj.get("season_id");
            Object matchesPlayed = goalsScoredObj.get("matches_played");
            Object minutesPlayed = goalsScoredObj.get("minutes_played");
            Object substituted = goalsScoredObj.get("substituted_in");
            int substitutedIn;
            if(!JSONObject.NULL.equals(substituted)){
                substitutedIn = (int) substituted;
            }else substitutedIn = 0;
            JSONObject innerGoals = goalsScoredObj.getJSONObject("goals");
            Object goalsHome = innerGoals.get("home");
            Object goalsAway = innerGoals.get("away");

    return new PlrScoreRecord((int) ranking,
            playerId,
            (int) teamId,
            (int) leagueId,
            (int) seasonId,
            (int) matchesPlayed, (int) minutesPlayed, substitutedIn, (int) goalsHome, (int) goalsAway);
    }
}
