package com.erkul.reactive.demo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class WebClientConfigurer {

    private final WebClientConfig webClientConfig;
    private final ReactorClientHTTPConnector connector;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(webClientConfig.getBaseUrl())
                .clientConnector(new ReactorClientHttpConnector(connector.getHttpClient()))
                .defaultHeaders(h -> h.setBearerAuth(webClientConfig.getBearerToken()))
                .build();
    }
}
