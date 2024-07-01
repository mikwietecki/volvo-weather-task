package com.m.wietecki.volvoweathertask.model.mapper;

import com.m.wietecki.volvoweathertask.model.ForecastDay;
import com.m.wietecki.volvoweathertask.model.apiResponse.ApiForecastDay;

public class ForecastMapper {
    public static ForecastDay mapApiForecastDayToForecastDay(ApiForecastDay apiForecastDay) {
        ForecastDay forecastDay = new ForecastDay();
        forecastDay.setDate(apiForecastDay.getDate());
        forecastDay.setMaxTempCelsius(apiForecastDay.getDay().getMaxtemp_c());
        forecastDay.setMinTempCelsius(apiForecastDay.getDay().getMintemp_c());
        forecastDay.setAvgTempCelsius(apiForecastDay.getDay().getAvgtemp_c());
        forecastDay.setMaxWindSpeedKmH(apiForecastDay.getDay().getMaxwind_kph());
        forecastDay.setTotalPrecipitationMm(apiForecastDay.getDay().getTotalprecip_mm());
        forecastDay.setTotalSnowfallCm(apiForecastDay.getDay().getTotalsnow_cm());
        forecastDay.setAvgHumidity(apiForecastDay.getDay().getAvghumidity());
        forecastDay.setAvgVisibilityKm(apiForecastDay.getDay().getAvgvis_km());
        forecastDay.setUvIndex(apiForecastDay.getDay().getUv());
        return forecastDay;
    }
}
