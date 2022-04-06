package com.example.weathertestfinal.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Alerts {
    private String sender_name;
    private String event;
    private long start;
    private long end;
    private String description;
    private List<String> tags;
}
