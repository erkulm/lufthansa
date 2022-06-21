package com.erkul.reactive.demo.service;

import com.erkul.reactive.demo.entity.City;
import com.erkul.reactive.demo.model.AirportDTO;
import com.erkul.reactive.demo.service.model.CitySearch;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public interface AirportService {
    Flux<AirportDTO> getAirports();

    void save(Flux<AirportDTO> airportDTOFlux);

    Flux<AirportDTO> searchAirports(String search);

    Flux<AirportDTO> searchAirports(CitySearch search);
}
