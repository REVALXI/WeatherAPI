package com.example.weatherapi.controller;

import com.example.weatherapi.WeatherAPIApplication;
import com.example.weatherapi.dto.*;
import com.example.weatherapi.service.WeatherServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import javax.validation.ConstraintViolationException;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(WeatherRestController.class)
class WeatherRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeatherServiceImpl weatherService;

    private final String BASE_ENDPOINT = "/Sydney";

    Response response = Response.builder()
            .lat(-33.87)
            .lon(151.21)
            .timezone("Australia/Sydney")
            .timezone_offset(36000L)
            .current(new Current(1651104759, 1651091218, 1651130294, 292.7, 293.03, 1017, 89, 290.84, 2.94, 75, 10000, 4.12, 300, new ArrayList<>(Collections.singletonList(new Weather(500, "Rain", "light rain", "10d"))), Collections.singletonMap("1h", 0.22)))
            .minutely(new ArrayList<>(Arrays.asList(new Minutely(1651104660,0.2442), new Minutely(1651104720,0.2514))))
            .hourly(new ArrayList<>(Arrays.asList(
                    new Hourly(1651118400,292.98,293.39,1015,91,291.47,1.56,75,10000,3.98,341,5.7,
                            new ArrayList<>(Collections.singletonList(new Weather(803,"Clouds","broken clouds","04d"))),0.24),
                    new Hourly(1651122000,293.39,293.74,1016,87,291.16,0.82,79,10000,3.46,351,5.06,
                            new ArrayList<>(Collections.singletonList(new Weather(803,"Clouds","broken clouds","04d"))),0.24))))
            .daily(new ArrayList<>(Arrays.asList(
                    new Daily(1651194000,1651177664,1651216631,1651170780,1651213860,0.94,
                            new Temp(296.19,290.85,297.26,293.39,297.01,291.12),
                            new FeelsLike(296.33,293.66,297.49,291.32),1020,68,290.08,4.71,31,
                            new ArrayList<>(Collections.singletonList(new Weather(500,"Rain","light rain","10d"))),55,0.41,0.45,5.26),
                    new Daily(1651280400,1651264110,1651302970,1651260780,1651301940,0.98,
                            new Temp(290.83,288.89,293.72,289.06,291.73,292.64),
                            new FeelsLike(290.82,288.51,291.68,292.86),1017,83,288.0,6.99,233,
                            new ArrayList<>(Collections.singletonList(new Weather(502,"Rain","heavy intensity rain","10d"))),100,1.0,9.36,2.16))))
            .alerts(Collections.singletonList(new Alerts("NWS Tulsa", "Heat Advisory", 1597341600, 1597366800,
                    "...HEAT ADVISORY REMAINS IN EFFECT FROM 1 PM THIS AFTERNOON TO 8 PM CDT THIS EVENING... * WHAT...Heat index values of 105 to 109 degrees expected. * WHERE...Creek, Okfuskee, Okmulgee, McIntosh, Pittsburg, Latimer, Pushmataha, and Choctaw Counties. * WHEN...From 1 PM to 8 PM CDT Thursday. * IMPACTS...The combination of hot temperatures and high humidity will combine to create a dangerous situation in which heat illnesses are possible.", Collections.singletonList("Extreme temperature value"))))
            .build();



    @Test
    @WithMockUser
    public void getCurrentWeatherSuccess() throws Exception {
        String endpoint = BASE_ENDPOINT+"/current";

        when(weatherService.getWeatherResponse(any())).thenReturn(response);

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get(endpoint).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.current.dt").value(response.getCurrent().getDt()));

    }


    @Test
    @WithMockUser
    public void getMinutelyWeatherSuccess() throws Exception {
        String endpoint = BASE_ENDPOINT+"/minutely";

        when(weatherService.getWeatherResponse(any())).thenReturn(response);

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get(endpoint).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.minutely[0].dt").value(response.getMinutely().get(0).getDt()))
                .andExpect(jsonPath("$.minutely[0].precipitation").value(response.getMinutely().get(0).getPrecipitation()))
                .andExpect(jsonPath("$.minutely[1].dt").value(response.getMinutely().get(1).getDt()))
                .andExpect(jsonPath("$.minutely[1].precipitation").value(response.getMinutely().get(1).getPrecipitation()));
    }

    @Test
    @WithMockUser
    public void getSingleMinutelyWeatherSuccess() throws Exception {
        String endpoint = BASE_ENDPOINT+"/minutely/1";

        when(weatherService.getWeatherResponse(any())).thenReturn(response);

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get(endpoint).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.minutelySingle.dt").value(response.getMinutelySingle().getDt()))
                .andExpect(jsonPath("$.minutelySingle.precipitation").value(response.getMinutelySingle().getPrecipitation()));
    }

    @Test
    @WithMockUser
    public void getHourlyWeatherSuccess() throws Exception {
        String endpoint = BASE_ENDPOINT+"/hourly";

        when(weatherService.getWeatherResponse(any())).thenReturn(response);

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get(endpoint).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.hourly[0].dt").value(response.getHourly().get(0).getDt()))
                .andExpect(jsonPath("$.hourly[0].clouds").value(response.getHourly().get(0).getClouds()))
                .andExpect(jsonPath("$.hourly[1].dt").value(response.getHourly().get(1).getDt()));
    }

    @Test
    @WithMockUser
    public void getSingleHourlyWeatherSuccess() throws Exception {
        String endpoint = BASE_ENDPOINT+"/hourly/1";

        when(weatherService.getWeatherResponse(any())).thenReturn(response);

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get(endpoint).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.hourlySingle.dt").value(response.getHourlySingle().getDt()))
                .andExpect(jsonPath("$.hourlySingle.temp").value(response.getHourlySingle().getTemp()));
    }


    @Test
    @WithMockUser
    public void getDailyWeatherSuccess() throws Exception {
        String endpoint = BASE_ENDPOINT+"/daily";

        when(weatherService.getWeatherResponse(any())).thenReturn(response);

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get(endpoint).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.daily[0].dt").value(response.getDaily().get(0).getDt()))
                .andExpect(jsonPath("$.daily[0].dew_point").value(response.getDaily().get(0).getDew_point()))
                .andExpect(jsonPath("$.daily[1].dt").value(response.getDaily().get(1).getDt()))
                .andExpect(jsonPath("$.daily[1].dew_point").value(response.getDaily().get(1).getDew_point()));
    }

    @Test
    @WithMockUser
    public void getSingleDailyWeatherSuccess() throws Exception {
        String endpoint = BASE_ENDPOINT+"/daily/0";

        when(weatherService.getWeatherResponse(any())).thenReturn(response);

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get(endpoint).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dailySingle.dt").value(response.getDailySingle().getDt()))
                .andExpect(jsonPath("$.dailySingle.dew_point").value(response.getDailySingle().getDew_point()));
    }

    @Test
    @WithMockUser
    public void getWeatherAlertsSuccess() throws Exception {
        String endpoint = BASE_ENDPOINT+"/alerts";

        when(weatherService.getWeatherResponse(any())).thenReturn(response);

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get(endpoint).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.alerts[0].sender_name").value(response.getAlerts().get(0).getSender_name()));

    }

    @Test
    @WithMockUser
    public void getNullPointerException() throws Exception {

        String endpoint = "/null/current";


        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get(endpoint).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof NullPointerException));
    }

    @Test
    @WithMockUser
    public void getLocationFileNotFoundException() throws Exception {
        String endpoint = BASE_ENDPOINT+"/daily/999";

        //when(weatherService.getWeatherResponse(any())).thenReturn(null);

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get(endpoint).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof ConstraintViolationException));
                //.andExpect(result -> assertEquals("Location not Available", result.getResolvedException().getMessage()));
    }

    @Test
    public void main() {
        WeatherAPIApplication.main(new String[] {});
    }
}