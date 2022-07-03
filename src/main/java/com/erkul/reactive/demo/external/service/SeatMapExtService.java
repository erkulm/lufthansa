package com.erkul.reactive.demo.external.service;

import com.erkul.reactive.demo.config.WebClientConfig;
import com.erkul.reactive.demo.external.model.seatmap.SeatMapResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeatMapExtService {
    private final WebClient webClient;
    private final WebClientConfig webClientConfig;

    public Mono<SeatMapResponse> getSeatMap(String flightNumber, String origin, String destination,
                                            String date, String cabinClass) {

        return webClient
                .get().uri(webClientConfig.getSeatMapUrl() + flightNumber + "/" + origin + "/" + destination + "/" + date + "/" + cabinClass)
                .retrieve().bodyToMono(SeatMapResponse.class);
    }

    public Mono<String> getFlightsString(String flightNumberRange, String startDate, String endDate,
                                         String origin, String destination, String daysOfOperation) {
        return webClient
                .get().uri(uriBuilder -> uriBuilder.path(webClientConfig.getFlightsUrl())
                        .queryParam("airlines", "LH")
                        .queryParamIfPresent("flightNumberRanges", Optional.of(flightNumberRange))
                        .queryParam("startDate", startDate)
                        .queryParam("endDate", endDate)
                        .queryParam("daysOfOperation", Objects.isNull(daysOfOperation) ? "1234567" : daysOfOperation)
                        .queryParam("timeMode", "UTC")
                        .queryParamIfPresent("origin", Optional.ofNullable(origin))
                        .queryParamIfPresent("destination", Optional.ofNullable(destination))
                        .queryParamIfPresent("aircraftTypes", Optional.empty())
                        .build())
                .retrieve().bodyToMono(String.class);
    }

}
