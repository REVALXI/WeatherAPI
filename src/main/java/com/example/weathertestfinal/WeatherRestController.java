package com.example.weathertestfinal;

import com.example.weathertestfinal.response.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
public class WeatherRestController {

    @Autowired
    private WeatherService service;

    @Value("classpath:location.json")
    Resource resourceFile;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/")
    public String home(){
        return("Available locations:<br>" +
                "Sydney, Canberra, Darwin, Brisbane, Adelaide, Hobard, Melbourne, Perth<br><br>" +
                "GET commands:<br>" +
                "/(location)/current<br>" +
                "/(location)/minutely<br>" +
                "/(location)/minutely/(id)<br>" +
                "/(location)/hourly<br>" +
                "/(location)/hourly/(id)<br>" +
                "/(location)/daily<br>" +
                "/(location)/daily/(id)<br>" +
                "/(location)/alerts<br>");

    }

    @GetMapping("/{location}/current")
    public CurrentWeather getCurrentWeather(@PathVariable String location){
        return service.getCurrentWeather(getResponse(location));
    }

    @GetMapping("/{location}/minutely")
    public MinutelyWeather getMinutelyWeather(@PathVariable String location){
        return service.getMinutelyWeather(getResponse(location));
    }

    //num = how many minutes in the future to forecast range (0-60)
    @GetMapping("/{location}/minutely/{num}")
    public Minutely getMinutelyWeather(@PathVariable String location, @PathVariable int num){
        try{
            return service.getMinutelyWeather(
                    getResponse(location)).getMinutely().get(num-1);
        }
        catch(IndexOutOfBoundsException exc){
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "1111111111", exc);
        }
    }

    @GetMapping("/{location}/hourly")
    public HourlyWeather getHourlyWeather(@PathVariable String location){
        return service.getHourlyWeather(getResponse(location));
    }

    //num = how many hours in the future to forecast range (1-48)
    @GetMapping("/{location}/hourly/{num}")
    public Hourly getHourlyWeather(@PathVariable String location, @PathVariable int num){
        try{
            return service.getHourlyWeather(
                    getResponse(location)).getHourly().get(num-1);

        }
        catch(IndexOutOfBoundsException exc){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "1111111111", exc);
        }
    }

    @GetMapping("/{location}/daily")
    public DailyWeather getDailyWeather(@PathVariable String location){
        return service.getDailyWeather(getResponse(location));
    }

    //num = how many days in the future to forecast range (0-7)
    @GetMapping("/{location}/daily/{num}")
    public Daily getDailyWeather(@PathVariable String location, @PathVariable int num){
        try{
            return service.getDailyWeather(getResponse(location)).getDaily().get(num);
        }
        catch(IndexOutOfBoundsException exc){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "1111111111", exc);
        }
    }

    @GetMapping("/{location}/alerts")
    public WeatherAlerts getWeatherAlerts(@PathVariable String location){
        return service.getWeatherAlerts(getResponse(location));
    }

    public double[] getResponse(String location){
        try{
            JsonNode jsonNode = objectMapper.readTree(resourceFile.getFile());
            double lat = jsonNode.get(location).get("lat").asDouble();
            double lon = jsonNode.get(location).get("lon").asDouble();
            System.out.println("111");
            return new double[]{lat, lon};
        }
        catch(FileNotFoundException exc){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "999999999", exc);
        }
        catch(FeignException.NotFound exc){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "1111111111", exc);
        }
        catch(Exception exc){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "A000000000000", exc);
        }
    }
}
