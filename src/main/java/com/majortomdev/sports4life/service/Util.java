package com.majortomdev.sports4life.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class Util {

    public String urlToString(URL url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        //System.setProperty("http.keepAlive", "false"); //vain attempts to fix the problem with 1 request only
        conn.connect();
        int responseCode = conn.getResponseCode();
        if(responseCode !=200){
            throw new RuntimeException("HttpResponseCode: "+responseCode);
        }else {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String dataLine;
            StringBuilder response = new StringBuilder();
            while ((dataLine = in.readLine()) != null) {
                response.append(dataLine);
            }
            in.close();
            //conn.disconnect();
            return response.toString();
        }
    }

    public Date createShortDateObjFromString(String strDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.parse(strDate);
    }

}
