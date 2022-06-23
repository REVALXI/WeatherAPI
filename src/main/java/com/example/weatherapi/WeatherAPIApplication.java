package com.example.weatherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WeatherAPIApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeatherAPIApplication.class, args);
    }
}
