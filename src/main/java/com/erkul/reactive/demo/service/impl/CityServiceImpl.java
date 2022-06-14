package com.erkul.reactive.demo.service.impl;

import com.erkul.reactive.demo.elastic.CityElasticRepository;
import com.erkul.reactive.demo.elastic.model.CityESO;
import com.erkul.reactive.demo.entity.City;
import com.erkul.reactive.demo.model.CityDTO;
import com.erkul.reactive.demo.repository.CityRepository;
import com.erkul.reactive.demo.service.CityService;
import com.erkul.reactive.demo.service.model.CitySearch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;

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
    public void save(Flux<City> cityFlux) {
        cityRepository.insert(cityFlux)
                .doOnNext(city -> cityElasticRepository.save(modelMapper.map(city, CityESO.class)).subscribe())
                .doOnError(throwable -> log.error(throwable.getMessage()))
                .subscribe();
    }

    @Override
    public Flux<CityDTO> searchCities(String search) {
        final Flux<CityESO> allByCityCodeContains = cityElasticRepository.findAllByCityCodeContains(search);
        return allByCityCodeContains.map(city -> modelMapper.map(city, CityDTO.class));
    }

    @Override
    public Flux<CityDTO> searchCities(CitySearch search) {
        if (!StringUtils.hasText(search.cityCode()))
            return cityElasticRepository.findAllByCountryCodeContains(search.countryCode())
                    .map(city -> modelMapper.map(city, CityDTO.class));
        if (!StringUtils.hasText(search.countryCode()))
            return cityElasticRepository.findAllByCityCodeContains(search.cityCode())
                    .map(city -> modelMapper.map(city, CityDTO.class));
        return cityElasticRepository.findAllByCityCodeContainsAndCountryCodeContains(search.cityCode(), search.countryCode())
                .map(city -> modelMapper.map(city, CityDTO.class));
    }

}
