package com.example.weatherapi.dto;

import lombok.*;

@Getter
@AllArgsConstructor
public class FeelsLike {
    private double day;
    private double night;
    private double eve;
    private double morn;
}
