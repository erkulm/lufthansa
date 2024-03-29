package com.erkul.reactive.demo.external.service;

import com.erkul.reactive.demo.config.WebClientConfig;
import com.erkul.reactive.demo.external.model.CitiesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityExtService {
    private final WebClient webClient;
    private final WebClientConfig webClientConfig;

    public Mono<CitiesResponse> getAllCities() {
        return webClient
                .get().uri(webClientConfig.getCitiesUrl())
                .retrieve().bodyToMono(CitiesResponse.class);
    }

    public Mono<CitiesResponse> getAllCities(final Integer limit, final Integer offset) {
        return webClient
                .get().uri(uriBuilder -> uriBuilder.path(webClientConfig.getCitiesUrl())
                        .queryParamIfPresent("limit", Optional.ofNullable(limit))
                        .queryParamIfPresent("offset", Optional.ofNullable(offset))
                        .build())
                .retrieve().bodyToMono(CitiesResponse.class);
    }


    public Mono<String> getAllCitiesString() {
        return webClient.get().uri(webClientConfig.getCitiesUrl())
                .retrieve()
                .bodyToMono(String.class).single();
    }
}
