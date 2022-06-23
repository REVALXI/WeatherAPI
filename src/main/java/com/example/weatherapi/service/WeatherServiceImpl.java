package com.example.weatherapi.service;

import com.example.weatherapi.client.WeatherRestConsumer;
import com.example.weatherapi.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl{

    private final WeatherRestConsumer weatherRestConsumer;

    @Value("${apikey}")
    String apikey = "f7fc17b9446d57bddf6d116dd8b29aa7";

    public Response getWeatherResponse(double[] coordinates){
        return weatherRestConsumer.getWeatherResponse(coordinates[0], coordinates[1], apikey);
    }
}
