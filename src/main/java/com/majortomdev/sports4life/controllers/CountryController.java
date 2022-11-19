package com.majortomdev.sports4life.controllers;

import com.majortomdev.sports4life.models.Country;
import com.majortomdev.sports4life.models.Team;
import com.majortomdev.sports4life.models.Venue;
import com.majortomdev.sports4life.service.CountryService;
import com.majortomdev.sports4life.service.SeasonsService;
import com.majortomdev.sports4life.service.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;
    @Autowired
    private SeasonsService seasonsService;
    @Autowired
    private Util util;

    private final String apikey = "0c9e5730-432c-11ed-89c2-457c4e0606d9";

    @GetMapping("/hello")
    public String hello() {
        return "hello motherTruckers!!";
    }

    @GetMapping("/bye")
    public String byee() {
        return "see ya later bro!!";
    }

    private List<Country> countries = new ArrayList<>();

    @GetMapping("/soccer/countries")
    public List<Country> getCountries(@RequestParam String continent) throws IOException {
        //test for validity of continent param???
        URL url = new URL("https://app.sportdataapi.com/api/v1/soccer/countries?apikey=" + apikey + "&continent=" + continent);
        String countriesString = util.urlToString(url);
        return countryService.getCountryData(countriesString);
    }

    @GetMapping("/soccer/country/{id}")
    public Country getCountryById(@PathVariable(value = "id") int id) throws IOException {
        URL url = new URL("https://app.sportdataapi.com/api/v1/soccer/countries/" + id + "?apikey=" + apikey);
        String countryString = util.urlToString(url);
        return countryService.getCountryById(countryString);
    }

    @GetMapping("/soccer/teams")
    public List<Team> getTeams(@RequestParam int countryId) throws IOException {
        URL url = new URL("https://app.sportdataapi.com/api/v1/soccer/teams?apikey=" + apikey + "&country_id=" + countryId);
        String teamsString = util.urlToString(url);
        return countryService.getTeamsInCountry(teamsString);
    }

    @GetMapping("/soccer/team/{id}")
    public Team getTeamById(@PathVariable(value = "id") int id) throws IOException {
        URL url = new URL("https://app.sportdataapi.com/api/v1/soccer/teams/" + id + "?apikey=" + apikey);
        String teamString = util.urlToString(url);
        return countryService.getTeamById(teamString);
    }

    @GetMapping("/soccer/venues")
    public List<Venue> getVenuesInCountry(@RequestParam int countryId) throws IOException {
        URL url = new URL("https://app.sportdataapi.com/api/v1/soccer/venues?apikey="+apikey+"&country_id=" + countryId);
        String venuesString = util.urlToString(url);
        return countryService.getVenuesByCountry(venuesString);
    }

    @GetMapping("/soccer/venues/{id}")
    public Venue getVenueById(@PathVariable(value = "id") int id) throws IOException {
        URL url = new URL("https://app.sportdataapi.com/api/v1/soccer/venues/"+id+"?apikey=" + apikey);
        String venueString = util.urlToString(url);
        return countryService.getVenueById(venueString);
    }
}