package com.m.wietecki.volvoweathertask.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherForecastApiResponse {

    private Location location;
    private Forecast forecast;

    @Getter
    @Setter
    public static class Location {
        private String name;
        private String region;
        private String country;
        private double lat;
        private double lon;
        private String tz_id;
        private long localtime_epoch;
        private String localtime;
    }

    @Getter
    @Setter
    public static class Forecast {
        private List<ForecastDay> forecastday;
    }

    @Getter
    @Setter
    public static class ForecastDay {
        private String date;
        private Day day;
    }

    @Getter
    @Setter
    public static class Day {
        private double maxtemp_c;
        private double mintemp_c;
        private double avgtemp_c;
        private double maxwind_kph;
        private double totalprecip_mm;
        private double totalsnow_cm;
        private double avgvis_km;
        private double avghumidity;
        private double uv;
    }

}