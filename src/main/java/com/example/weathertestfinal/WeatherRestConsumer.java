package com.example.weathertestfinal;

import com.example.weathertestfinal.response.*;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

@FeignClient(name="Weather-Service", url = "https://api.openweathermap.org/")
public interface WeatherRestConsumer {

    @GetMapping()
    CurrentWeather getCurrentWeather(URI baseUrl);

    @GetMapping()
    MinutelyWeather getMinutelyWeather(URI baseUrl);

    @GetMapping()
    HourlyWeather getHourlyWeather(URI baseUrl);

    @GetMapping()
    DailyWeather getDailyWeather(URI baseUrl);

    @GetMapping()
    WeatherAlerts getWeatherAlerts(URI baseUrl);
}
