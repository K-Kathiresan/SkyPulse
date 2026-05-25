package com.project.weatherapp.controller;

import com.project.weatherapp.dto.WeatherResponse;
import com.project.weatherapp.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final WeatherService weatherService;

    public HelloController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public WeatherResponse getWeather(@RequestParam String city) {
        if(city == null || city.trim().isEmpty()) {
        throw new IllegalArgumentException("City cannot be empty");
    }
        return weatherService.getWeather(city);
    }
    @GetMapping("/weather/location")
        public WeatherResponse getWeatherByLocation(
                @RequestParam double lat,
                @RequestParam double lon){

            return weatherService.getWeatherByCoordinates(lat, lon);
        }
            
}