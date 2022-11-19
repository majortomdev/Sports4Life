package com.majortomdev.sports4life.controllers;

import com.majortomdev.sports4life.models.Player;
import com.majortomdev.sports4life.models.PlrScoreRecord;
import com.majortomdev.sports4life.service.GoalsService;
import com.majortomdev.sports4life.service.PlayerService;
import com.majortomdev.sports4life.service.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.List;

@RestController
public class PlayerController {


    @Autowired
    private PlayerService playerService;
    @Autowired
    private GoalsService goalsService;
    @Autowired
    private Util util;

    private final String apikey = "0c9e5730-432c-11ed-89c2-457c4e0606d9";

    @GetMapping("/soccer/players")
    public List<Player> getPlayersByCountry(@RequestParam int countryId,
                                            @RequestParam(required = false) Integer minAge,
                                            @RequestParam(required = false) Integer maxAge) throws IOException, ParseException {
        if(maxAge == null) maxAge = 55;//REQUIRED=FALSE was the ticket!!!!
        if(minAge == null) minAge = 15;// ..WITH these safeguards to rotect the params before they are called
        URL url = new URL("https://app.sportdataapi.com/api/v1/soccer/players?apikey="+apikey+
                "&country_id="+countryId+"&min_age="+minAge+"&max_age="+maxAge);//MAX_age. MIN_age are optional!!!!
        String playersAsString = util.urlToString(url);
        return playerService.getPlayersByCountry(playersAsString);
    }
    @GetMapping("/soccer/players/{id}")
    public Player getPlayerById(@PathVariable(value = "id") int id) throws IOException, ParseException {
        URL url = new URL("https://app.sportdataapi.com/api/v1/soccer/players/"+id+"?apikey="+apikey);
        String playerString = util.urlToString(url);
        return playerService.getPlayerById(playerString);
    }

    @GetMapping("/soccer/topscorers")
    public List<PlrScoreRecord> getPlayerGoalsScoredForSeason(@RequestParam int seasonId) throws IOException{
        URL url = new URL("https://app.sportdataapi.com/api/v1/soccer/topscorers?apikey="+apikey+"&season_id="+seasonId);
        String goalsScoredString = util.urlToString(url);
        return goalsService.getSeasonGoals(goalsScoredString);
    }

    @GetMapping("/soccer/topscorersbyteam")
    public List<PlrScoreRecord> getTeamGoalsScoredForSeason(@RequestParam int seasonId, @RequestParam int teamId) throws IOException{
        URL url = new URL("https://app.sportdataapi.com/api/v1/soccer/topscorers?apikey="+apikey+"&season_id="+seasonId);
        String goalsScoredString = util.urlToString(url);
        return goalsService.getSeasonTeamGoals(goalsScoredString,teamId);
    }

}
