package com.example.weatherapi.controller;

import com.example.weatherapi.dto.*;
import com.example.weatherapi.service.WeatherServiceImpl;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@Validated
public class WeatherRestController {

    private final WeatherServiceImpl weatherService;

    @Autowired
    private Environment env;

    @GetMapping("/error")
    public void handleErrors(){
        throw new NotFoundException("Not Found");
    }

    @GetMapping("/{location}/current")
    public Response getCurrentWeather(@PathVariable String location) {
        return GetWeather(location, "current", null);
    }

    @GetMapping("/{location}/minutely")
    public Response getMinutelyWeather(@PathVariable String location) {
        return GetWeather(location, "minutely", null);
    }

    //num = how many minutes in the future to forecast range (0-60)
    @GetMapping("/{location}/minutely/{num}")
    public Response getMinutelyWeather(@PathVariable String location, @PathVariable @Range(min = 0, max = 60, message = "Please enter a value from 0 to 60") int num) {
        return GetWeather(location, "minutelySingle", num - 1);
    }

    @GetMapping("/{location}/hourly")
    public Response getHourlyWeather(@PathVariable String location) {
        return GetWeather(location, "hourly", null);
    }

    //num = how many hours in the future to forecast range (1-48)
    @GetMapping("/{location}/hourly/{num}")
    public Response getHourlyWeather(@PathVariable String location, @PathVariable @Range(min = 1, max = 48, message = "Please enter a value from 1 to 48") int num) {
        return GetWeather(location, "hourlySingle", num - 1);
    }

    @GetMapping("/{location}/daily")
    public Response getDailyWeather(@PathVariable String location) {
        return GetWeather(location, "daily", null);
    }

    //num = how many days in the future to forecast range (0-7)
    @GetMapping("/{location}/daily/{num}")
    public Response getDailyWeather(@PathVariable String location, @PathVariable @Range(min = 0, max = 7, message = "Please enter a value from 0 to 7") int num) {
        return GetWeather(location, "dailySingle", num);
    }

    @GetMapping("/{location}/alerts")
    public Response getWeatherAlerts(@PathVariable String location) {
        return GetWeather(location, "alerts", null);
    }

    public double[] getCoordinates(String location) {
        double lat = Double.parseDouble(Objects.requireNonNull(env.getProperty("location." + location + ".lat")));
        double lon = Double.parseDouble(Objects.requireNonNull(env.getProperty("location." + location + ".lon")));
        return new double[]{lat, lon};
    }

    public Response GetWeather(String location, String responseType, Integer num) {
        Response response = weatherService.getWeatherResponse(getCoordinates(location));
        if(num != null){
            if(Objects.equals(responseType, "minutelySingle")){
                response.setMinutelySingle(response.getMinutely().get(num));
            }
            if(Objects.equals(responseType, "hourlySingle")){
                response.setHourlySingle(response.getHourly().get(num));
            }
            if(Objects.equals(responseType, "dailySingle")){
                response.setDailySingle(response.getDaily().get(num));
            }
        }

        if(!Objects.equals(responseType, "current")){
            response.setCurrent(null);
        }
        if(!Objects.equals(responseType, "minutely")){
            response.setMinutely(null);
        }
        if(!Objects.equals(responseType, "hourly")){
            response.setHourly(null);
        }
        if(!Objects.equals(responseType, "daily")){
            response.setDaily(null);
        }
        if(!Objects.equals(responseType, "alerts")){
            response.setAlerts(null);
        }
        return response;
    }
}