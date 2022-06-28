package com.erkul.reactive.demo.rest;

import com.erkul.reactive.demo.model.AirportDTO;
import com.erkul.reactive.demo.service.AirportService;
import com.erkul.reactive.demo.service.model.AirportSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("airports")
@RequiredArgsConstructor
public class AirportRestService {
    private final AirportService airportService;

    @GetMapping
    public ResponseEntity<Flux<AirportDTO>> getAllCities() {
        return ResponseEntity.ok(airportService.getAirports());
    }

    @GetMapping("/get-by-code")
    public ResponseEntity<Mono<AirportDTO>> getAirportByCode(@RequestParam String code) {
        return ResponseEntity.ok(airportService.searchAirportsByCode(code));
    }

    @GetMapping("/search")
    public ResponseEntity<Flux<AirportDTO>> searchAirports(@RequestBody AirportSearch search) {
        return ResponseEntity.ok(airportService.searchAirports(search));
    }

    @GetMapping("/search-by-name-or-code")
    public ResponseEntity<Flux<AirportDTO>> searchAirports(@RequestParam String text, @RequestParam String language) {
        return ResponseEntity.ok(airportService.getAirportsByCityOrAirportNameOrCodeContaining(text, language));
    }

}
