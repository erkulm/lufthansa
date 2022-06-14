package com.erkul.reactive.demo.rest;

import com.erkul.reactive.demo.model.CityDTO;
import com.erkul.reactive.demo.service.CityService;
import com.erkul.reactive.demo.service.model.CitySearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("cities")
@RequiredArgsConstructor
public class CityRestService {
    private final CityService cityService;

    @GetMapping
    public Flux<CityDTO> getAllCities() {
        return cityService.getCities();
    }

    @GetMapping("/get-by-code")
    public Flux<CityDTO> getCities(@PathVariable String search) {
        return cityService.searchCities(search);
    }

    @GetMapping("/search")
    public Flux<CityDTO> getCities(@RequestBody CitySearch search) {
        return cityService.searchCities(search);
    }

}
