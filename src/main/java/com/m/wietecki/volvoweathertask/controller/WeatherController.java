package com.m.wietecki.volvoweathertask.controller;

import com.m.wietecki.volvoweathertask.model.WeatherForecast;
import com.m.wietecki.volvoweathertask.service.WeatherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
@Tag(name = "Weather API")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/forecast")
    @Operation(summary = "Get weather forecast for cities")
    public List<WeatherForecast> getWeatherForecast() {
        return weatherService.getWeatherForecastForCities();
    }
}
