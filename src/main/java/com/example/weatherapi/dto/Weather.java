package com.example.weatherapi.dto;

import lombok.*;

@Getter
@AllArgsConstructor
public class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;
}
