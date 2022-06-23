package com.example.weatherapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Response {
    private Double lat;
    private Double lon;
    private String timezone;
    private Long timezone_offset;
    private Current current;
    private Minutely minutelySingle;
    private List<Minutely> minutely;
    private Hourly hourlySingle;
    private List<Hourly> hourly;
    private Daily dailySingle;
    private List<Daily> daily;
    private List<Alerts> alerts;
}

