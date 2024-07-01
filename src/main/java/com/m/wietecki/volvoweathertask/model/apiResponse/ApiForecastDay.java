package com.m.wietecki.volvoweathertask.model.apiResponse;

import lombok.Data;

@Data
public class ApiForecastDay {
    private String date;
    private Day day;
}
