package com.erkul.reactive.demo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class WebClientConfigurer {

    private final WebClientConfig webClientConfig;
    private final ReactorClientHTTPConnector connector;

    @Bean
    public WebClient webClient() {
        final int size = 16 * 1024 * 1024;
        final ExchangeStrategies strategies = ExchangeStrategies.builder()
                .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size))
                .build();
        return WebClient.builder()
                .exchangeStrategies(strategies)
                .baseUrl(webClientConfig.getBaseUrl())
                .clientConnector(new ReactorClientHttpConnector(connector.getHttpClient()))
                .defaultHeaders(h -> h.setBearerAuth(webClientConfig.getBearerToken()))
                .build();
    }
}
