package com.erkul.reactive.demo.rest;

import com.erkul.reactive.demo.model.CityDTO;
import com.erkul.reactive.demo.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("cities")
@RequiredArgsConstructor
public class CityRestService {
    private final CityService cityService;

    @GetMapping
    public Flux<CityDTO> getAllCities(){
        return cityService.getCities();
    }

    @GetMapping("/{search}")
    public Flux<CityDTO> getCities(@PathVariable String search) {
        return cityService.searchCities(search);
    }

}
