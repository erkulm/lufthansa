package com.erkul.reactive.demo.service;

import com.erkul.reactive.demo.model.CityDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

@Service
public interface CityService {
    Flux<Set<CityDTO>> getCities();
    void saveCity(Mono<CityDTO> cityDTOMono);
}
