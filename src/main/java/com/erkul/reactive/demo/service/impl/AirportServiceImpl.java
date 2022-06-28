package com.erkul.reactive.demo.service.impl;

import com.erkul.reactive.demo.elastic.AirportElasticRepository;
import com.erkul.reactive.demo.elastic.CityElasticRepository;
import com.erkul.reactive.demo.elastic.model.AirportESO;
import com.erkul.reactive.demo.entity.Airport;
import com.erkul.reactive.demo.model.AirportDTO;
import com.erkul.reactive.demo.repository.AirportRepository;
import com.erkul.reactive.demo.service.AirportService;
import com.erkul.reactive.demo.service.model.AirportSearch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class AirportServiceImpl implements AirportService {
    private final AirportRepository airportRepository;
    private final CityElasticRepository cityElasticRepository;
    private final ModelMapper modelMapper;
    private final AirportElasticRepository airportElasticRepository;

    @Override
    public Flux<AirportDTO> getAirports() {
        return airportElasticRepository.findAll().map(airport -> modelMapper.map(airport, AirportDTO.class));
    }

    @Override
    public Flux<AirportDTO> getAirportsByCityOrAirportNameOrCodeContaining(String text, String languageCode) {
        final Flux<AirportDTO> airportsByCityNames =
                cityElasticRepository.findAllByCityNames_NameLikeAndCityNames_LanguageCodeEquals(text, languageCode)
                        .flatMap(cityESO -> airportElasticRepository.findAllByCityCode(cityESO.getCityCode()))
                        .map(airportESO -> modelMapper.map(airportESO, AirportDTO.class))
                        .map(airportDTO -> {
                            airportDTO.getAirportNames().removeIf(nameAndLang -> !languageCode.equals(nameAndLang.getLanguageCode()));
                            return airportDTO;
                        });

        final Flux<AirportDTO> airports = airportElasticRepository
                .findAllByAirportNames_NameLikeAndAirportNames_LanguageCodeEquals(text, languageCode)
                .map(airport -> modelMapper.map(airport, AirportDTO.class))
                .map(airportDTO -> {
                    airportDTO.getAirportNames().removeIf(nameAndLang -> !languageCode.equals(nameAndLang.getLanguageCode()));
                    return airportDTO;
                });

        return Flux.merge(airportsByCityNames, airports).distinct();
    }


    @Override
    public void save(Flux<AirportDTO> airportDTOFlux) {
        airportRepository.insert(airportDTOFlux.map(airportDTO -> modelMapper.map(airportDTO, Airport.class)))
                .flatMap(airport -> airportElasticRepository.save(modelMapper.map(airport, AirportESO.class)))
                .doOnError(throwable -> log.error(throwable.getMessage()))
                .subscribe();
    }

    @Override
    public Mono<AirportDTO> searchAirportsByCode(String search) {
        final Mono<AirportESO> allByCityCodeContains = airportElasticRepository.findByAirportCode(search);
        return allByCityCodeContains.map(airportESO -> modelMapper.map(airportESO, AirportDTO.class));
    }

    @Override
    public Flux<AirportDTO> searchAirports(AirportSearch search) {
        if (!StringUtils.hasText(search.cityCode()) && !StringUtils.hasText(search.airportCode()))
            return airportElasticRepository.findAllByCountryCode(search.countryCode())
                    .map(airport -> modelMapper.map(airport, AirportDTO.class));
        if (!StringUtils.hasText(search.countryCode()) && !StringUtils.hasText(search.airportCode()))
            return airportElasticRepository.findAllByCityCode(search.cityCode())
                    .map(airport -> modelMapper.map(airport, AirportDTO.class));
        if (!StringUtils.hasText(search.countryCode()) && !StringUtils.hasText(search.cityCode()))
            return airportElasticRepository.findAllByAirportCode(search.airportCode())
                    .map(airport -> modelMapper.map(airport, AirportDTO.class));
        return airportElasticRepository.findAllByCityCodeAndCountryCode(search.cityCode(), search.countryCode())
                .map(airport -> modelMapper.map(airport, AirportDTO.class));
    }

}
