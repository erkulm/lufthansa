package com.erkul.reactive.demo.service;

import com.erkul.reactive.demo.entity.City;
import com.erkul.reactive.demo.model.CityDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface CityService {
    Flux<CityDTO> getCities();
    void saveCities(Flux<CityDTO> cityDTOMono);

    Flux<City> save(Flux<City> cityFlux);

    Mono<City> saveEntity(CityDTO cityFlux);

    Flux<CityDTO> searchCities(String search);
}
