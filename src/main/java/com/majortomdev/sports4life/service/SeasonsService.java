package com.majortomdev.sports4life.service;

import com.majortomdev.sports4life.controllers.CountryController;
import com.majortomdev.sports4life.models.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

@Service
public class SeasonsService {

    @Autowired
    private Util util;
    private CountryController countryController;
    private final String apikey = "3a175000-2890-11ed-a522-0949cf027ab6";

    public List<Season> getSeasonsForLeague(String jsonSeasonsString) throws ParseException {
        List<Season> seasons = new ArrayList<>();
        JSONObject jsonObj = new JSONObject(jsonSeasonsString);
        JSONArray seasonsArray = jsonObj.getJSONArray("data");
        for (int i = 0; i < seasonsArray.length(); i++) {
            JSONObject jsonSeason = seasonsArray.getJSONObject(i);
            seasons.add(createSeasonInstance(jsonSeason));
        }
        return seasons;
    }

    public Season getSeasonById(String jsonSeason) throws ParseException {
        JSONObject jsonOb = new JSONObject(jsonSeason);
        JSONObject seasonInfo = jsonOb.getJSONObject("data");
        return createSeasonInstance(seasonInfo);
    }

    private Season createSeasonInstance(JSONObject jsonSeason) throws ParseException {
        Object seasonId = jsonSeason.get("season_id");
        String name = (String) jsonSeason.get("name");
        Object isCurr = jsonSeason.get("is_current");
        boolean isCurrent = false;
        if ((int) isCurr == 1) {
            isCurrent = true;
        }
        Object countryId = jsonSeason.get("country_id");
        Object leagueId = jsonSeason.get("league_id");

        Date startDate = util.createShortDateObjFromString((String) jsonSeason.get("start_date"));
        Date endDate = util.createShortDateObjFromString((String) jsonSeason.get("end_date"));

        return new Season((int)seasonId, name, isCurrent,(int)countryId,
                (int)leagueId,startDate,endDate);

    }

    public List<Standing> getStandingsForSeason(String jsonSeasonResults){
        List<Standing> standings = new ArrayList<>();
        JSONObject jsonObj = new JSONObject(jsonSeasonResults);
        JSONObject dataObj = jsonObj.getJSONObject("data");
        JSONArray standingsArray = dataObj.getJSONArray("standings");

        for (int i=0; i<standingsArray.length(); i++){
            JSONObject standingJson = standingsArray.getJSONObject(i);
            standings.add(createStandingInstance(standingJson));
        }
        return standings;
    }

    private Standing createStandingInstance(JSONObject jsonStanding){
        Object teamId = jsonStanding.get("team_id");
        Object position = jsonStanding.get("position");
        Object points = jsonStanding.get("points");
        String status = (String)jsonStanding.get("status");

        Object res = jsonStanding.get("result");
        String result;
        if(!JSONObject.NULL.equals(res)){
            result = (String) res;
        }else result = "";

        Map<String,SeasonStats> statsForSeason = new LinkedHashMap<>();
        JSONObject overall = jsonStanding.getJSONObject("overall");
        JSONObject home = jsonStanding.getJSONObject("home");
        JSONObject away = jsonStanding.getJSONObject("away");

        statsForSeason.put("overall",createSeasonsStatsInstance(overall));
        statsForSeason.put("home",createSeasonsStatsInstance(home));
        statsForSeason.put("away",createSeasonsStatsInstance(away));
        return new Standing((int)teamId,(int)position,(int)points,status,result,statsForSeason);
    }

    private SeasonStats createSeasonsStatsInstance(JSONObject jsonSeasonStats){
        Object played = jsonSeasonStats.get("games_played");
        Object wins = jsonSeasonStats.get("won");
        Object draws = jsonSeasonStats.get("draw");
        Object losses = jsonSeasonStats.get("lost");
        Object goalDiff = jsonSeasonStats.get("goals_diff");
        Object goalsFor = jsonSeasonStats.get("goals_scored");
        Object goalsAgainst = jsonSeasonStats.get("goals_against");

        return new SeasonStats((int)played,(int)wins,(int)draws,
                (int)losses,(int)goalDiff,(int)goalsFor,(int)goalsAgainst);
    }

    public List<TeamResult> getSeasonOverlookDisplay(String jsonStandings) throws IOException {
        List<TeamResult> standings = new ArrayList<>();
        JSONObject jsonObj = new JSONObject(jsonStandings);
        JSONObject dataObj = jsonObj.getJSONObject("data");
        int seasonId = (int)dataObj.get("season_id");
        int leagueId = (int)dataObj.get("league_id");
        JSONArray standingsArray = dataObj.getJSONArray("standings");
        for(int i=0; i<standingsArray.length(); i++){
            JSONObject standingObj = standingsArray.getJSONObject(i);
            String name = getTeamNameFromId((int)standingObj.get("team_id"));
            int position = (int) standingObj.get("position");
            int points = (int) standingObj.get("points");
            JSONObject stats = standingObj.getJSONObject("overall");
            int wins = (int)stats.get("won");
            int losses = (int)stats.get("lost");
            int draws = (int)stats.get("draw");
            int goalDiff = (int)stats.get("goals_diff");
            standings.add(new TeamResult(seasonId,leagueId,name,position,points,wins,losses,draws,goalDiff));
        }
        return standings;
    }

    private String getTeamNameFromId(@PathVariable int teamId) throws IOException {
        final String uri = "http://localhost:8080/soccer/team/" + teamId;
        RestTemplate restTemplate = new RestTemplate();
        Team bTeam = restTemplate.getForObject(uri, Team.class);
        return bTeam.getName();
    }

    public List<Match> getRequestedMatches(String jsonMatches){
        List<Match> matches = new ArrayList<>();
        JSONObject jsonObj = new JSONObject(jsonMatches);
        JSONArray matchesArray = jsonObj.getJSONArray("data");
        for (int i=0; i<matchesArray.length(); i++){
            JSONObject matchObj = matchesArray.getJSONObject(i);
            int status = (int)matchObj.get("status_code");
            if(status!=3)continue;
            int matchId = (int)matchObj.get("match_id");
            JSONObject rd = matchObj.getJSONObject("round");
            int round = Integer.parseInt(rd.getString("name"));
            JSONObject home = matchObj.getJSONObject("home_team");
            int homeId = (int)home.get("team_id");
            JSONObject away = matchObj.getJSONObject("away_team");
            int awayId = (int)away.get("team_id");
            JSONObject scores = matchObj.getJSONObject("stats");
            String score = (String)scores.getString("ft_score");
            String halfTimeScore = (String)scores.getString("ht_score");

            matches.add(new Match(matchId,round,homeId,awayId,score,halfTimeScore));
        }
        return matches;
    }

    public List<Match> getMatchesByTeam(String jsonMatches, int team) {
        List<Match> matches = new ArrayList<>();
        JSONObject jsonObj = new JSONObject(jsonMatches);
        JSONArray matchesArray = jsonObj.getJSONArray("data");
        for (int i=0; i<matchesArray.length(); i++){
            JSONObject matchObj = matchesArray.getJSONObject(i);
            int status = (int)matchObj.get("status_code");
            if(status!=3)continue;
            JSONObject home = matchObj.getJSONObject("home_team");
            int homeId = (int)home.get("team_id");
            JSONObject away = matchObj.getJSONObject("away_team");
            int awayId = (int)away.get("team_id");
            if(homeId!=team && awayId!=team){
                continue;
            }
            int matchId = (int)matchObj.get("match_id");
            JSONObject rd = matchObj.getJSONObject("round");
            int round = Integer.parseInt(rd.getString("name"));
            JSONObject scores = matchObj.getJSONObject("stats");
            String score = (String)scores.getString("ft_score");
            String halfTimeScore = (String)scores.getString("ht_score");

            matches.add(new Match(matchId,round,homeId,awayId,score,halfTimeScore));
        }
        return matches;

    }

}