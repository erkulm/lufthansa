package com.erkul.reactive.demo.rest;

import com.erkul.reactive.demo.model.CityDTO;
import com.erkul.reactive.demo.service.CityService;
import com.erkul.reactive.demo.service.model.CitySearch;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("cities")
@RequiredArgsConstructor
public class CityRestService {
    private final CityService cityService;

    @GetMapping
    public ResponseEntity<Flux<CityDTO>> getAllCities() {
        return ResponseEntity.ok(cityService.getCities());
    }

    @GetMapping("/get-by-code")
    public ResponseEntity<Flux<CityDTO>> getCities(@RequestParam String code) {
        return ResponseEntity.ok(cityService.searchCities(code));
    }

    @GetMapping("/search")
    public ResponseEntity<Flux<CityDTO>> getCities(@RequestBody CitySearch search) {
        return ResponseEntity.ok(cityService.searchCities(search));
    }

}
