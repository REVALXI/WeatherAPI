package com.example.weathertestfinal.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FeelsLike {
    private double day;
    private double night;
    private double eve;
    private double morn;
}
