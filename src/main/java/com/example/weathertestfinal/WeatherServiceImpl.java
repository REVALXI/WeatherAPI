package com.example.weathertestfinal;

import com.example.weathertestfinal.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class WeatherServiceImpl implements WeatherService{
    @Autowired
    private WeatherRestConsumer weatherFiegnClient;


    URI determinedBasePathUri = URI.create("https://api.openweathermap.org/data/2.5/onecall?lat=-33.87&lon=151.21&exclude=current,minutely,hourly,daily,alerts&appid=f7fc17b9446d57bddf6d116dd8b29aa7");

    @Override
    public Response getCurrentWeather(){
        return weatherFiegnClient.getCurrentWeather();
    }

    @Override
    public Response getDailyWeather2(){
        //weatherFiegnClient.lat = "d";
        return weatherFiegnClient.getDailyWeather2(determinedBasePathUri);
    }
}
