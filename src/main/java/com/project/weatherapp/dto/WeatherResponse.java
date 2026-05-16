package com.project.weatherapp.dto;

public class WeatherResponse {

    private String city;
    private double temperature;
    private String condition;
    private int humidity;
    private String icon;

    public WeatherResponse() {
    }

    public WeatherResponse(String city, double temperature,
                       String condition, int humidity,
                       String icon) {

    this.city = city;
    this.temperature = temperature;
    this.condition = condition;
    this.humidity = humidity;
    this.icon = icon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}