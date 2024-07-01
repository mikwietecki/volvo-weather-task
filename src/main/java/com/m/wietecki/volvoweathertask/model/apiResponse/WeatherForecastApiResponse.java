package com.m.wietecki.volvoweathertask.model.apiResponse;

import lombok.Data;

@Data
public class WeatherForecastApiResponse {
    private Location location;
    private Forecast forecast;
}
