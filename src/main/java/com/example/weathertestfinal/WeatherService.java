package com.example.weathertestfinal;

import com.example.weathertestfinal.response.*;
import org.springframework.context.annotation.Bean;

public interface WeatherService {
    CurrentWeather getCurrentWeather(double[] coordinates);
    MinutelyWeather getMinutelyWeather(double[] coordinates);
    HourlyWeather getHourlyWeather(double[] coordinates);
    DailyWeather getDailyWeather(double[] coordinates);
    WeatherAlerts getWeatherAlerts(double[] coordinates);
}
