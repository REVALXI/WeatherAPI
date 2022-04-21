package com.example.weathertestfinal;

import com.example.weathertestfinal.response.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

//@WebMvcTest(WeatherRestController.class)
@SpringBootTest
//@ContextConfiguration(classes = {WeatherService.class, WeatherServiceImpl.class, WeatherRestConsumer.class})
//@ComponentScan
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

//    @Autowired
//    MockMvc mockMvc;

    //@ExtendWith(SpringRunner.class)

    //@MockBean
    //@MockBean
//    @Autowired
//    WeatherService service;
//
//    @Autowired
//    ObjectMapper objectMapper;
//
//    //@MockBean
//    @Autowired
//    WeatherRestConsumer consumer;
//
//    @Test
//    void testTest(){
//        WebTestClient client;
//        client = WebTestClient.bindToController(new WeatherRestController(service)).build();
//        client.get()
//                .uri("/Sydney/current")
//                .accept(MediaType.APPLICATION_JSON)
//                .exchange()
//                .expectStatus().isOk()
//                .expectHeader().contentType(MediaType.APPLICATION_JSON);
//    }
}