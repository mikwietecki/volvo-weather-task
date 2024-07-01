package com.m.wietecki.volvoweathertask.controller;

import com.m.wietecki.volvoweathertask.model.WeatherForecast;
import com.m.wietecki.volvoweathertask.service.WeatherServiceImplementation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
@Tag(name = "Weather API")
public class WeatherController {

    private final WeatherServiceImplementation weatherServiceImplementation;

    public WeatherController(WeatherServiceImplementation weatherServiceImplementation) {
        this.weatherServiceImplementation = weatherServiceImplementation;
    }

    @GetMapping("/forecast")
    @Operation(summary = "Get weather forecast for cities")
    public List<WeatherForecast> getWeatherForecast() {
        return weatherServiceImplementation.getWeatherForecastForCities();
    }
}
