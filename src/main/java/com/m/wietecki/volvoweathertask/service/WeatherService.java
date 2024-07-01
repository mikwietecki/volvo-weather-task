package com.m.wietecki.volvoweathertask.service;

import com.m.wietecki.volvoweathertask.config.AppPropertiesConfig;
import com.m.wietecki.volvoweathertask.model.ForecastDay;
import com.m.wietecki.volvoweathertask.model.WeatherForecast;
import com.m.wietecki.volvoweathertask.model.apiResponse.ApiForecastDay;
import com.m.wietecki.volvoweathertask.model.apiResponse.WeatherForecastApiResponse;
import com.m.wietecki.volvoweathertask.model.mapper.ForecastMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService implements WeatherServiceImplementation {
    private final AppPropertiesConfig appPropertiesConfig;
    public WeatherService(AppPropertiesConfig appPropertiesConfig) {
        this.appPropertiesConfig = appPropertiesConfig;
    }

    @Override
    public List<WeatherForecast> getWeatherForecastForCities() {
        List<WeatherForecast> forecasts = new ArrayList<>();
        for (String city : appPropertiesConfig.getCities()) {
            forecasts.add(getWeatherForecastForCity(city));
        }
        return forecasts;
    }

    private WeatherForecast getWeatherForecastForCity(String city) {
        String url = String.format("http://api.weatherapi.com/v1/forecast.json?key=%s&q=%s&days=%d&aqi=no&alerts=no",
                appPropertiesConfig.getApiKey(),
                appPropertiesConfig.getCities(),
                appPropertiesConfig.getDays());

        RestTemplate restTemplate = new RestTemplate();

        WeatherForecastApiResponse response = restTemplate.getForObject(url, WeatherForecastApiResponse.class);

        WeatherForecast forecast = new WeatherForecast();
        forecast.setCity(city);

        List<ForecastDay> forecastDays = new ArrayList<>();
        for (ApiForecastDay apiForecastDay : response.getForecast().getForecastday()) {
            ForecastDay forecastDay = ForecastMapper.mapApiForecastDayToForecastDay(apiForecastDay);
            forecastDays.add(forecastDay);
        }

        forecast.setForecastDays(forecastDays);
        return forecast;
    }
}
