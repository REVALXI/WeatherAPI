package com.example.weatherapi.dto;

import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
public class Hourly {
    private long dt;
    private double temp;
    private double feels_like;
    private long pressure;
    private long humidity;
    private double dew_point;
    private double uvi;
    private long clouds;
    private long visibility;
    private double wind_speed;
    private long wind_deg;
    private double wind_gust;
    private List<Weather> weather;
    private double pop;
}
