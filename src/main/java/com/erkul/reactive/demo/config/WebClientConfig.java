package com.erkul.reactive.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "webclient")
@Getter
@Setter
public class WebClientConfig {
    private String baseUrl;
    private String citiesUrl;
    private String airportsUrl;
    private String bearerToken;
    private String flightsUrl;
    private String seatMapUrl;
}
