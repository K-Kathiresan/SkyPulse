package com.project.weatherapp.service;

import com.project.weatherapp.dto.WeatherResponse;
import com.project.weatherapp.model.WeatherApiResponse;
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
}