package com.erkul.reactive.demo.service.impl;

import com.erkul.reactive.demo.elastic.AirportElasticRepository;
import com.erkul.reactive.demo.elastic.model.AirportESO;
import com.erkul.reactive.demo.elastic.model.CityESO;
import com.erkul.reactive.demo.entity.Airport;
import com.erkul.reactive.demo.model.AirportDTO;
import com.erkul.reactive.demo.model.CityDTO;
import com.erkul.reactive.demo.repository.AirportRepository;
import com.erkul.reactive.demo.service.AirportService;
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
public class AirportServiceImpl implements AirportService {
    private final AirportRepository airportRepository;
    private final ModelMapper modelMapper;
    private final AirportElasticRepository airportElasticRepository;

    @Override
    public Flux<AirportDTO> getAirports() {
        return airportElasticRepository.findAll().map(airport -> modelMapper.map(airport, AirportDTO.class));
    }


    @Override
    public void save(Flux<AirportDTO> airportDTOFlux) {
        airportRepository.insert(airportDTOFlux.map(airportDTO -> modelMapper.map(airportDTO, Airport.class)))
                .doOnNext(airport -> airportElasticRepository.save(modelMapper.map(airport, AirportESO.class)).subscribe())
                .doOnError(throwable -> log.error(throwable.getMessage()))
                .subscribe();
    }

    @Override
    public Flux<AirportDTO> searchAirports(String search) {
        final Flux<AirportESO> allByCityCodeContains = airportElasticRepository.findAllByCityCodeContains(search);
        return allByCityCodeContains.map(airportESO -> modelMapper.map(airportESO, AirportDTO.class));
    }

    @Override
    public Flux<AirportDTO> searchAirports(CitySearch search) {
        if (!StringUtils.hasText(search.cityCode()))
            return airportElasticRepository.findAllByCountryCodeContains(search.countryCode())
                    .map(airport -> modelMapper.map(airport, AirportDTO.class));
        if (!StringUtils.hasText(search.countryCode()))
            return airportElasticRepository.findAllByCityCodeContains(search.cityCode())
                    .map(airport -> modelMapper.map(airport, AirportDTO.class));
        return airportElasticRepository.findAllByCityCodeContainsAndCountryCodeContains(search.cityCode(), search.countryCode())
                .map(airport -> modelMapper.map(airport, AirportDTO.class));
    }

}
