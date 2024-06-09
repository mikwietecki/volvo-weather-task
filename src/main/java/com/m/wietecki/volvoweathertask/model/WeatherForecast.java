package com.m.wietecki.volvoweathertask.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherForecast {
    private String city;
    private List<ForecastDay> forecastDays;

    @Getter
    @Setter
    public static class ForecastDay {
        private String date;
        //Temperature in Celsius
        private double maxTemp;
        private double minTemp;
        private double avgTemp;

        //wind speed in km/h
        private double maxWind;

        //Precipitation in milimeters
        private double totalPCPN;

        //Snowfall in centimeters
        private double totalSnowfall;
        private double avgHumidity;

        //Average visibility in kilometers
        private double avgVisibility;
        private double uvIndex;
    }
}