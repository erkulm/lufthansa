package com.erkul.reactive.demo.service;

import com.erkul.reactive.demo.model.AirportDTO;
import com.erkul.reactive.demo.service.model.AirportSearch;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface AirportService {
    Flux<AirportDTO> getAirports();

    void save(Flux<AirportDTO> airportDTOFlux);

    Mono<AirportDTO> searchAirportsByCode(String search);

    Flux<AirportDTO> searchAirports(AirportSearch search);
}
