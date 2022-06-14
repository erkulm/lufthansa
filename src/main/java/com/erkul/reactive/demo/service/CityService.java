package com.erkul.reactive.demo.service;

import com.erkul.reactive.demo.entity.City;
import com.erkul.reactive.demo.model.CityDTO;
import com.erkul.reactive.demo.service.model.CitySearch;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public interface CityService {
    Flux<CityDTO> getCities();

    void save(Flux<City> cityFlux);

    Flux<CityDTO> searchCities(String search);

    Flux<CityDTO> searchCities(CitySearch search);
}
