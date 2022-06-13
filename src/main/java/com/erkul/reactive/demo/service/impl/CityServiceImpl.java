package com.erkul.reactive.demo.service.impl;

import com.erkul.reactive.demo.entity.City;
import com.erkul.reactive.demo.model.CityDTO;
import com.erkul.reactive.demo.repository.CityRepository;
import com.erkul.reactive.demo.repository.elastic.CityElasticRepository;
import com.erkul.reactive.demo.repository.elastic.model.CityESO;
import com.erkul.reactive.demo.service.CityService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;
    private final CityElasticRepository cityElasticRepository;

    @Override
    public Flux<CityDTO> getCities() {
        return cityRepository.findAll().map(city -> modelMapper.map(city, CityDTO.class));
    }

    @Override
    public void saveCities(Flux<CityDTO> cityDTOFlux) {
        //TODO
    }

    @Override
    public Flux<City> save(Flux<City> cityFlux) {
        return cityRepository.insert(cityFlux)
                .doOnNext(city -> cityElasticRepository.save(
                        CityESO.builder().id(city.getId())
                                .cityCode(city.getCityCode()).build()));
    }

    @Override
    public Mono<City> saveEntity(CityDTO cityFlux) {
        final City entity = modelMapper.map(cityFlux, City.class);
        return cityRepository.insert(entity);
    }

    @Override
    public Flux<CityDTO> searchCities(String search) {
        final Flux<City> allByCityCodeContains = cityRepository.findAllByCityCodeContains(search);
        return allByCityCodeContains.map(city -> modelMapper.map(city, CityDTO.class));
    }

    public void saveOneCity(Mono<City> cityFlux) {
        cityRepository.insert(cityFlux);
    }
}
