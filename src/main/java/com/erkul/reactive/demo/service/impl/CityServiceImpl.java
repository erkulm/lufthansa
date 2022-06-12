package com.erkul.reactive.demo.service.impl;

import com.erkul.reactive.demo.external.model.City;
import com.erkul.reactive.demo.model.CityDTO;
import com.erkul.reactive.demo.repository.CityRepository;
import com.erkul.reactive.demo.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    @Override
    public Flux<Set<CityDTO>> getCities() {
        return null;
    }

    @Override
    public void saveCity(Mono<CityDTO> cityDTOMono) {
//        cityRepository.save(cityDTOMono.);
    }
}
