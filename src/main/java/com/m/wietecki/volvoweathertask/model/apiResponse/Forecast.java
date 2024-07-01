package com.m.wietecki.volvoweathertask.model.apiResponse;

import lombok.Data;

import java.util.List;

@Data
public class Forecast {
    private List<ApiForecastDay> forecastday;
}
