package com.erkul.reactive.demo.external.rest;

import com.erkul.reactive.demo.external.model.FlightSearchResponse;
import com.erkul.reactive.demo.external.service.FlightSearchExtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "external/flights")
@RequiredArgsConstructor
public class FlightSearchExtRest {
    private final FlightSearchExtService flightSearchExtService;

    @GetMapping
    public Flux<FlightSearchResponse> getFlights() {
        return flightSearchExtService.getFlights(null, "12AUG22", "12AUG22", "FRA", "IST", null);
    }

    @GetMapping("/string")
    public Mono<String> getCitiesString() {
        return flightSearchExtService.getFlightsString(null, "12AUG22", "12AUG22", "FRA", "IST", null);
    }
}
