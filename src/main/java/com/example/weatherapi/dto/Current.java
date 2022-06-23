package com.example.weatherapi.dto;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class Current {
    private long dt;
    private long sunrise;
    private long sunset;
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
    private List<Weather> weather;
    private Map<String, Double> rain;
}
