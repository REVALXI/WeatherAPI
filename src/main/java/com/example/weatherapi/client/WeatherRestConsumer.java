package com.example.weatherapi.client;

import com.example.weatherapi.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name="Weather-Service", url = "${url}")
public interface WeatherRestConsumer {
    @GetMapping("${getapi}")
    Response getWeatherResponse(@RequestParam("lat") double lat, @RequestParam("lon") double lon, @RequestParam("appid") String apikey);
}
