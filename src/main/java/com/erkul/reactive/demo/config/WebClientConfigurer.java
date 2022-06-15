package com.erkul.reactive.demo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class WebClientConfigurer {

    private final WebClientConfig webClientConfig;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(webClientConfig.getBaseUrl())
                .defaultHeaders(h -> h.setBearerAuth(webClientConfig.getBearerToken()))
                .build();
    }
}
