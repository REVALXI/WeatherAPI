package com.example.weathertestfinal;

import com.example.weathertestfinal.response.Response;

public interface WeatherService {
    Response getCurrentWeather();
    Response getDailyWeather2();
}
