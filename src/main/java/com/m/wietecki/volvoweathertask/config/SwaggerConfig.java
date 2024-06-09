package com.m.wietecki.volvoweathertask.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("Weather API")
                        .version("1.0")
                        .description("Weather forecast for next 3 days, for the 5 largest cities in Poland")
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .email("m.wietecki@icloud.com")));
    }
}
