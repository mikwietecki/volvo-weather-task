package com.m.wietecki.volvoweathertask.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Getter
public class AppPropertiesConfig {

    @Value("${api.key}")
    private String apiKey;

    @Value("${cities}")
    private List<String> cities;

    @Value("${number_of_days}")
    private int days;
}
