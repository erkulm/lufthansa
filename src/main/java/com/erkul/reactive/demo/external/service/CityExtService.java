package com.erkul.reactive.demo.external.service;

import com.erkul.reactive.demo.external.model.CitiesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Service
@RequiredArgsConstructor
public class CityExtService {
    private final HttpClient httpClient;

    public Mono<CitiesResponse> getAllCities() {
        WebClient client = WebClient.builder()
                .baseUrl("https://api.lufthansa.com/v1/mds-references/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
        return client.get().uri("/cities")
                .headers(h->h.setBearerAuth("3hauc6n8rygyn8j267k3frce"))
                .retrieve().bodyToMono(CitiesResponse.class);
    }


    public Mono<String> getAllCitiesString() {
        WebClient client = WebClient.builder()
                .baseUrl("https://api.lufthansa.com/v1/mds-references/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();

        return client.get().uri("/cities")
                .headers(h->h.setBearerAuth("3hauc6n8rygyn8j267k3frce"))
                .retrieve()
                .bodyToMono(String.class).single();
    }
}
