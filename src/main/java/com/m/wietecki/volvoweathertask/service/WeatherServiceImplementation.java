package com.m.wietecki.volvoweathertask.service;

import com.m.wietecki.volvoweathertask.model.WeatherForecast;

import java.util.List;

public interface WeatherServiceImplementation {
    List<WeatherForecast> getWeatherForecastForCities();
}
