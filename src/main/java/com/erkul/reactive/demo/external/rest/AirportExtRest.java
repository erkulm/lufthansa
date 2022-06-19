package com.erkul.reactive.demo.external.rest;

import com.erkul.reactive.demo.external.model.AirportsResponse;
import com.erkul.reactive.demo.external.model.CitiesResponse;
import com.erkul.reactive.demo.external.service.AirportExtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "external/airports")
@RequiredArgsConstructor
public class AirportExtRest {
    private final AirportExtService airportExtService;

    @GetMapping
    public Mono<AirportsResponse> getCities() {
        return airportExtService.getAllAirports();
    }

    @GetMapping("/string")
    public Mono<String> getCitiesString() {
        return airportExtService.getAllCitiesString();
    }
}
