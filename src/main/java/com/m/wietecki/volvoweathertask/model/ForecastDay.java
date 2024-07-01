package com.m.wietecki.volvoweathertask.model;

import lombok.Data;

@Data
public class ForecastDay {
    private String date;
    private double maxTempCelsius;
    private double minTempCelsius;
    private double avgTempCelsius;
    private double maxWindSpeedKmH;
    private double totalPrecipitationMm;
    private double totalSnowfallCm;
    private double avgHumidity;
    private double avgVisibilityKm;
    private double uvIndex;
}
