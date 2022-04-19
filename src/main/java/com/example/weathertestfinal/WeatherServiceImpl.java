package com.example.weathertestfinal;

import com.example.weathertestfinal.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class WeatherServiceImpl implements WeatherService{
    @Autowired
    private WeatherRestConsumer consumer;

    private URI determinedBasePathUri;

    @Override
    public CurrentWeather getCurrentWeather(double[] coordinates){
        SetURL(coordinates[0], coordinates[1]);
        return consumer.getCurrentWeather(determinedBasePathUri);
    }

    @Override
    public MinutelyWeather getMinutelyWeather(double[] coordinates){
        SetURL(coordinates[0], coordinates[1]);
        return consumer.getMinutelyWeather(determinedBasePathUri);
    }

    @Override
    public HourlyWeather getHourlyWeather(double[] coordinates){
        SetURL(coordinates[0], coordinates[1]);
        return consumer.getHourlyWeather(determinedBasePathUri);
    }

    @Override
    public DailyWeather getDailyWeather(double[] coordinates){
        SetURL(coordinates[0], coordinates[1]);
        return consumer.getDailyWeather(determinedBasePathUri);
    }

    @Override
    public WeatherAlerts getWeatherAlerts(double[] coordinates){
        SetURL(coordinates[0], coordinates[1]);
        return consumer.getWeatherAlerts(determinedBasePathUri);
    }

    public void SetURL(double lat, double lon)
    {
        determinedBasePathUri = URI.create("https://api.openweathermap.org/data/2.5/onecall?lat="+ lat + "&lon=" + lon + "&exclude=&appid=f7fc17b9446d57bddf6d116dd8b29aa7");
    }
}
