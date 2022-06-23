package com.example.weatherapi.dto;

import lombok.*;

@Getter
@AllArgsConstructor
public class Temp {
    private double day;
    private double min;
    private double max;
    private double night;
    private double eve;
    private double morn;
}
