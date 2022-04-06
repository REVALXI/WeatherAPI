package com.example.weathertestfinal;

import com.example.weathertestfinal.response.Response;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

@FeignClient(name="Weather-Service", url = "https://api.openweathermap.org/")
public interface WeatherRestConsumer {

    @GetMapping("data/2.5/onecall?lat=-33.87&lon=151.21&exclude=minutely,hourly,daily&appid=f7fc17b9446d57bddf6d116dd8b29aa7")
    Response getCurrentWeather();

//    @RequestLine("GET /&exclude=current,minutely,hourly,daily,alerts&appid=f7fc17b9446d57bddf6d116dd8b29aa7")
//    Response getDailyWeather(URI baseUrl);

    @GetMapping()
    Response getDailyWeather2(URI baseUrl);

//    @GetMapping("/alerts")
//    public String getAlerts();
//
//    @GetMapping("lat=33.44&lon=-94.04&appid=f7fc17b9446d57bddf6d116dd8b29aa7")
//    public String getWeather(@PathVariable String lat);
}
