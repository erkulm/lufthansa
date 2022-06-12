package com.erkul.reactive.demo.rest;

import com.erkul.reactive.demo.external.model.CitiesResponse;
import com.erkul.reactive.demo.external.service.CityExtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "cities")
@RequiredArgsConstructor
public class CityRest {
    private final CityExtService cityExtService;

    @GetMapping
    public Mono<CitiesResponse> getCities() {
        return cityExtService.getAllCities();
    }

    @GetMapping("/string")
    public Mono<String> getCitiesString() {
        return cityExtService.getAllCitiesString();
    }
}
