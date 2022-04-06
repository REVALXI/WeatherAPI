package com.example.weathertestfinal;

import com.example.weathertestfinal.response.Response;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.net.URI;

@RestController
public class WeatherRestController {

    @Autowired
    private WeatherService consumer;


    @GetMapping("/current")
    public Response getCurrentWeather() {
        return consumer.getCurrentWeather();
    }

//    @Value("classpath:location.json")
//    Resource resourceFile;
//
//    @Autowired
//    ObjectMapper objectMapper;

    @RequestMapping("/test/{location}")
    public Response getDailyWeather2(@PathVariable String location) throws IOException {
//        JsonNode jsonNode = objectMapper.readTree(resourceFile.getFile());
//        try{
//            String lat = jsonNode.get(location).get("lat").toString();
//            System.out.println(lat);
//            return getDailyWeather(lat);
//        }
//        catch(Exception e){
//            System.out.println("111");
//        }
//        System.out.println("222");
//        return null;
        return consumer.getDailyWeather2();
    }


//    @GetMapping("/test/{location}")
//    public String getDailyWeather(@PathVariable String location) throws IOException {
//        float lat;
//        float lon;
//        String l;
//
//        File resource = new ClassPathResource(
//                "location.json").getFile();
//        l = new String(
//                Files.readAllBytes(resource.toPath()));
//
//        //resourceFile.getFile("qwe");
//
//        return l;
//    }


//    @GetMapping("/alerts")
//    public String getBooksInfo() {
//        return "Accessing from STUDENT-SERVICE ==> " + consumer.getAlerts();
//    }
//
//    @GetMapping("/lat={lat}")
//    @ResponseBody
//    public String getWeather(@PathVariable String lat){
//        String request = "lat="+lat+"&lon=-94.04&appid=f7fc17b9446d57bddf6d116dd8b29aa7";
//        return consumer.getWeather(request);
//        //return request;
//    }
}
