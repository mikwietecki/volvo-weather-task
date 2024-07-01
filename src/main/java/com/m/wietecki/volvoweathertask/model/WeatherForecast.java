package com.m.wietecki.volvoweathertask.model;

import lombok.Data;

import java.util.List;

@Data
public class WeatherForecast {
    private String city;
    private List<ForecastDay> forecastDays;
}
