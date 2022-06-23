package com.example.weatherapi.dto;

import lombok.*;

@Getter
@AllArgsConstructor
public class Minutely extends Response{
    private long dt;
    private double precipitation;
}


