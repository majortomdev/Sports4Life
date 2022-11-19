package com.majortomdev.sports4life.service;

import com.majortomdev.sports4life.models.League;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeagueService {

    public List<League> getLeaguesFromCountry(String leaguesJson){
        List<League> leagues = new ArrayList<>();
        JSONObject jsonResults = new JSONObject(leaguesJson);
        JSONObject dataObj = jsonResults.getJSONObject("data");

        dataObj.keySet().forEach( key -> {
            JSONObject insideObj = dataObj.getJSONObject(key);
            Object leagueId = insideObj.get("league_id");
            Object countryId = insideObj.get("country_id");
            String name = (String)insideObj.get("name");
            leagues.add(new League((int)leagueId,(int)countryId,name));
        });

        return leagues;
    }

    public League getLeagueById (String jsonLeagueString) {
        JSONObject jsonLeague = new JSONObject(jsonLeagueString);
        JSONObject leagueInfo = jsonLeague.getJSONObject("data");

        Object leagueId = leagueInfo.get("league_id");
        Object countryId = leagueInfo.get("country_id");
        String name = (String)leagueInfo.get("name");

        return new League((int)leagueId,(int)countryId,name);
    }

}
