package com.example.weathertestfinal.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;
}
