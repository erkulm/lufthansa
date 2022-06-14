package com.erkul.reactive.demo.service.impl;

import com.erkul.reactive.demo.entity.City;
import com.erkul.reactive.demo.model.CityDTO;
import com.erkul.reactive.demo.repository.CityRepository;
import com.erkul.reactive.demo.elastic.CityElasticRepository;
import com.erkul.reactive.demo.elastic.model.CityESO;
import com.erkul.reactive.demo.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;
    private final CityElasticRepository cityElasticRepository;

    @Override
    public Flux<CityDTO> getCities() {
        return cityElasticRepository.findAll().map(city -> modelMapper.map(city, CityDTO.class));
    }

    @Override
    public void saveCities(Flux<CityDTO> cityDTOFlux) {
        //TODO
    }

    @Override
    public void save(Flux<City> cityFlux) {
        cityRepository.insert(cityFlux)
                .delayElements(Duration.ofMillis(100))
                .doOnNext(city -> cityElasticRepository.save(modelMapper.map(city, CityESO.class)).subscribe())
                .doOnError(throwable -> log.error(throwable.getMessage()))
                .subscribe();
    }

    @Override
    public Mono<City> saveEntity(CityDTO cityFlux) {
        final City entity = modelMapper.map(cityFlux, City.class);
        return cityRepository.insert(entity);
    }

    @Override
    public Flux<CityDTO> searchCities(String search) {
        final Flux<CityESO> allByCityCodeContains = cityElasticRepository.findAllByCityCodeContains(search);
        return allByCityCodeContains.map(city -> modelMapper.map(city, CityDTO.class));
    }

    public void saveOneCity(Mono<City> cityFlux) {
        cityRepository.insert(cityFlux);
    }
}
