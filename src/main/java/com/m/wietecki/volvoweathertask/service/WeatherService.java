package com.m.wietecki.volvoweathertask.service;

import com.m.wietecki.volvoweathertask.model.WeatherForecast;
import com.m.wietecki.volvoweathertask.model.WeatherForecastApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WeatherService {
    private static final String API_KEY = "9db18a719c2e447abc8162531240806";
    private static final List<String> CITIES = Arrays.asList("Warsaw", "Lodz", "Krakow", "Wroclaw", "Poznan");

    public List<WeatherForecast> getWeatherForecastForCities() {
        List<WeatherForecast> forecasts = new ArrayList<>();
        for (String city : CITIES) {
            forecasts.add(getWeatherForecastForCity(city));
        }
        return forecasts;
    }

    private WeatherForecast getWeatherForecastForCity(String city) {
        String url = String.format("http://api.weatherapi.com/v1/forecast.json?key=%s&q=%s&days=3&aqi=no&alerts=no", API_KEY, city);
        RestTemplate restTemplate = new RestTemplate();

        WeatherForecastApiResponse response = restTemplate.getForObject(url, WeatherForecastApiResponse.class);

        WeatherForecast forecast = new WeatherForecast();
        forecast.setCity(city);

        List<WeatherForecast.ForecastDay> forecastDays = new ArrayList<>();
        for (WeatherForecastApiResponse.ForecastDay apiForecastDay : response.getForecast().getForecastday()) {
            WeatherForecast.ForecastDay forecastDay = getForecastDay(apiForecastDay);
            forecastDays.add(forecastDay);
        }

        forecast.setForecastDays(forecastDays);
        return forecast;
    }

    private static WeatherForecast.ForecastDay getForecastDay(WeatherForecastApiResponse.ForecastDay apiForecastDay) {
        WeatherForecast.ForecastDay forecastDay = new WeatherForecast.ForecastDay();
        forecastDay.setDate(apiForecastDay.getDate());
        forecastDay.setMaxTemp(apiForecastDay.getDay().getMaxtemp_c());
        forecastDay.setMinTemp(apiForecastDay.getDay().getMintemp_c());
        forecastDay.setAvgTemp(apiForecastDay.getDay().getAvgtemp_c());
        forecastDay.setMaxWind(apiForecastDay.getDay().getMaxwind_kph());
        forecastDay.setTotalPCPN(apiForecastDay.getDay().getTotalprecip_mm());
        forecastDay.setTotalSnowfall(apiForecastDay.getDay().getTotalsnow_cm());
        forecastDay.setAvgHumidity(apiForecastDay.getDay().getAvghumidity());
        forecastDay.setAvgVisibility(apiForecastDay.getDay().getAvgvis_km());
        forecastDay.setUvIndex(apiForecastDay.getDay().getUv());
        return forecastDay;
    }
}
