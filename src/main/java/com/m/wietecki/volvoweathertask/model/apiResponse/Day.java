package com.m.wietecki.volvoweathertask.model.apiResponse;

import lombok.Data;

@Data
public class Day {
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
