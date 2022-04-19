package com.example.weathertestfinal;

import com.example.weathertestfinal.response.Response;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeatherRestControllerTest {
//    WeatherRestController controller;
//
//    @Before
//    public void beforeTest() throws MalformedURLException {
//        template = new TestRestTemplate(username, password);
//        base = new URL("http://localhost:" + port);
//    }
//    @Test
//    public void testGetCurrentWeather() throws IOException {
//        Response response = controller.getCurrentWeather("Sydney");
//        //assertEquals(response.getLat(), -33.87);
//    }



    @Test
    void UserAbleToAccessHomepage(){
        WeatherRestController controller = new WeatherRestController();
        assertEquals("Available locations:<br>" +
                "Sydney, Canberra, Darwin, Brisbane, Adelaide, Hobard, Melbourne, Perth<br><br>" +
                "GET commands:<br>" +
                "/(location)/current<br>" +
                "/(location)/minutely<br>" +
                "/(location)/minutely/(id)<br>" +
                "/(location)/hourly<br>" +
                "/(location)/hourly/(id)<br>" +
                "/(location)/daily<br>" +
                "/(location)/daily/(id)<br>" +
                "/(location)/alerts<br>", controller.home());
    }

//    TestRestTemplate template;
//    URL base;
//    @BeforeEach
//    public void beforeTest() throws MalformedURLException {
//        System.out.println("hutdfygiuhoijihugiyf");
//        TestRestTemplate template = new TestRestTemplate("username", "password");
//        int port = 8080;
//        base = new URL("http://localhost:" + port);
//    }
//    WeatherRestController controller = new WeatherRestController();
//    @Test
//    void GetCurrentWeather() throws IOException {
//        WeatherRestController controller = new WeatherRestController();
//        template.getForEntity(base.toString()+"/Sydney", String.class).getBody();
//        assertEquals(controller.getCurrentWeather("Sydney").getLat(), -33.87);
//    }
//
//    WebTestClient testClient = WebTestClient.bindToController(controller).build();
//
//    @Test
//    void TESD(){
//        WebTestClient testClient = WebTestClient
//                .bindToController(controller)
//                .build();
//
//    }
}