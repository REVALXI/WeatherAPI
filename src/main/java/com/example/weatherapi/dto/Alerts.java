package com.example.weatherapi.dto;

import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
public class Alerts {
    private String sender_name;
    private String event;
    private long start;
    private long end;
    private String description;
    private List<String> tags;
}
