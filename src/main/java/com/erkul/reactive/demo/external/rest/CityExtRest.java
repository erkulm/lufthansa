package com.erkul.reactive.demo.external.rest;

import com.erkul.reactive.demo.external.model.CitiesResponse;
import com.erkul.reactive.demo.external.service.CityExtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "external/cities")
@RequiredArgsConstructor
public class CityExtRest {
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
