package com.project.weatherapp.service;

import com.project.weatherapp.dto.WeatherResponse;
import com.project.weatherapp.model.WeatherApiResponse;

import tools.jackson.databind.JsonNode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.project.weatherapp.exception.CityNotFoundException;
import org.springframework.web.client.HttpClientErrorException;
@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    public WeatherResponse getWeather(String city) {

        String url = apiUrl
                + "?key="
                + apiKey
                + "&q="
                + city;

        RestTemplate restTemplate = new RestTemplate();

                try {

            WeatherApiResponse apiResponse =
                    restTemplate.getForObject(url, WeatherApiResponse.class);

            WeatherResponse response = new WeatherResponse(
                apiResponse.getLocation().getName(),
                apiResponse.getCurrent().getTemp_c(),
                apiResponse.getCurrent().getCondition().getText(),
                apiResponse.getCurrent().getHumidity(),
                apiResponse.getCurrent().getCondition().getIcon()
);

            return response;

        } catch (HttpClientErrorException e) {

            throw new CityNotFoundException("City not found");
        }

    }
    public WeatherResponse getWeatherByCoordinates(
        double lat,
        double lon){

    String url =
        "http://api.weatherapi.com/v1/current.json?key="
        + apiKey
        + "&q="
        + lat
        + ","
        + lon;

    RestTemplate restTemplate = new RestTemplate();

    JsonNode root = restTemplate.getForObject(url, JsonNode.class);

    WeatherResponse response = new WeatherResponse();

    response.setCity(
        root.path("location").path("name").asText()
    );

    response.setTemperature(
        root.path("current").path("temp_c").asDouble()
    );

    response.setCondition(
        root.path("current")
            .path("condition")
            .path("text")
            .asText()
    );

    response.setHumidity(
        root.path("current").path("humidity").asInt()
    );

    response.setIcon(
        root.path("current")
            .path("condition")
            .path("icon")
            .asText()
    );

    return response;
}
}