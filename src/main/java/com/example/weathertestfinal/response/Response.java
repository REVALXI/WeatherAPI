package com.example.weathertestfinal.response;

import com.example.weathertestfinal.response.Alerts;
import com.example.weathertestfinal.response.Current;
import lombok.*;

import java.util.List;

//@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Response {
    private double lat;
    private double lon;
    private String timezone;
    private long timezone_offset;
    private Current current;
    //private List<Minutely> minutely;
    //private List<Hourly> hourly;
    //private List<Daily> daily;
    //private List<Alerts> alerts;
    private List<Alerts> alerts;
}

