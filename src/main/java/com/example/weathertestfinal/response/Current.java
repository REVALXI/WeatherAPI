package com.example.weathertestfinal.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
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
    private Map rain;
}
