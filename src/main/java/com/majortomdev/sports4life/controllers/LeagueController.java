package com.majortomdev.sports4life.controllers;

import com.majortomdev.sports4life.models.League;
import com.majortomdev.sports4life.models.Match;
import com.majortomdev.sports4life.models.Season;
import com.majortomdev.sports4life.models.TeamResult;
import com.majortomdev.sports4life.service.LeagueService;
import com.majortomdev.sports4life.service.SeasonsService;
import com.majortomdev.sports4life.service.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.List;

@RestController
public class LeagueController {

    @Autowired
    private LeagueService leagueService;

    @Autowired
    private SeasonsService seasonsService;

    @Autowired
    private Util util;

    //private final String apikey = "3a175000-2890-11ed-a522-0949cf027ab6";
    private final String apikey = "0c9e5730-432c-11ed-89c2-457c4e0606d9";

    @GetMapping("/soccer/leagues")
    public List<League> getLeaguesByCountry(@RequestParam int countryId) throws IOException {

        URL url = new URL("https://app.sportdataapi.com/api/v1/soccer/leagues?apikey="
                + apikey + "&country_id=" + countryId);
        String leaguesString= util.urlToString(url);
        return leagueService.getLeaguesFromCountry(leaguesString);
    }

    @GetMapping("soccer/league/{id}")
    public League getLeagueById(@PathVariable(value = "id") int id) throws IOException {
        URL url = new URL("https://app.sportdataapi.com/api/v1/soccer/leagues/"+id+"?apikey="+apikey);
        String leagueString= util.urlToString(url);
        return leagueService.getLeagueById(leagueString);
    }

    @GetMapping("/soccer/seasons")
    public List<Season> getSeasons(@RequestParam int leagueId) throws IOException, ParseException {
        URL url = new URL("https://app.sportdataapi.com/api/v1/soccer/seasons?apikey="+apikey+"&league_id="+leagueId);
        String seasonsString = util.urlToString(url);
        return seasonsService.getSeasonsForLeague(seasonsString);
    }

    @GetMapping("/soccer/getSeasonId")
    public int getSeasonId(@RequestParam int leagueId, @RequestParam String year ) throws IOException, ParseException {
        List<Season> seasonsForGivenLeague = getSeasons(leagueId);
        System.out.println("YYYEEEEEhaa SEASONID been triggered");
        for(Season season: seasonsForGivenLeague){
            String name = season.getName();
            if(name.equals(year)||name.substring(2).equals(year.substring(0,2))){
                return season.getSeasonId();
            }
        }
        return 0;
    }

    @GetMapping("/soccer/season/{id}")
    public Season getSeasonById(@PathVariable(value = "id") int id) throws IOException, ParseException {
        URL url = new URL("https://app.sportdataapi.com/api/v1/soccer/seasons/"+id+"?apikey="+apikey);
        String seasonString = util.urlToString(url);
        return seasonsService.getSeasonById(seasonString);
    }

//    @GetMapping("/soccer/standings") //i could mkae this a diff url to below, wud hit the same EP and then do whatever different processing i may need with the list of Standing objects that im building from it
//    public List<Standing> getLeagueStandingsForSeason(@RequestParam int seasonId) throws IOException{
//        URL url = new URL("https://app.sportdataapi.com/api/v1/soccer/standings?apikey="+apikey+"&season_id="+seasonId);
//        String seasonsStandings = util.urlToString(url);
//        return seasonsService.getStandingsForSeason(seasonsStandings);
//    }

    @GetMapping("/soccer/standings/{seasonId}")
    public List<TeamResult> getLeagueStandingsDisplayForSeason(@PathVariable (value = "seasonId")int seasonId) throws IOException{
        System.out.println("GIDDYUP- STANDINGS been triggered");
        URL url = new URL("https://app.sportdataapi.com/api/v1/soccer/standings?apikey="+apikey+"&season_id="+seasonId);
        String teamStandings = util.urlToString(url);
        List<TeamResult> seasonsStandings = seasonsService.getSeasonOverlookDisplay(teamStandings);
        return seasonsStandings;
    }

//    @GetMapping("/soccer/matches")
//    public List<Match> getMatchesForSeason(@RequestParam int seasonId,
//                                        @RequestParam(required = false) Integer round,
//                                        @RequestParam(required = false) String dateFrom,
//                                        @RequestParam(required = false) String dateTo) throws IOException {
//        URL url = new URL("https://app.sportdataapi.com/api/v1/soccer/matches?apikey="+apikey+"&season_id="+seasonId+"&date_from="
//                +dateFrom+"&date_to="+dateTo);
//        String matchesPerReq = util.urlToString(url);
//        return seasonsService.getRequestedMatches(matchesPerReq);
//    }


    @GetMapping("/soccer/matches")
    public List<Match> getMatchesForSeason(@RequestParam int seasonId) throws IOException {
        URL url = new URL("https://app.sportdataapi.com/api/v1/soccer/matches?apikey="+apikey+"&season_id="+seasonId);
        String matchesBySeason = util.urlToString(url);
        return seasonsService.getRequestedMatches(matchesBySeason);
    }

    @GetMapping("/soccer/matches/{teamId}")
    public List<Match> getSeasonMatchesByTeam(@PathVariable (value = "teamId")int teamId,
                                              @RequestParam int seasonId) throws IOException {
        URL url = new URL("https://app.sportdataapi.com/api/v1/soccer/matches?apikey="+apikey+"&season_id="+seasonId);
        String matchesBySeason = util.urlToString(url);
        return seasonsService.getMatchesByTeam(matchesBySeason, teamId);

    }

}
