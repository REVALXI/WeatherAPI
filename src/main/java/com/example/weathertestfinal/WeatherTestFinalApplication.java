package com.example.weathertestfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WeatherTestFinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherTestFinalApplication.class, args);
    }

}
