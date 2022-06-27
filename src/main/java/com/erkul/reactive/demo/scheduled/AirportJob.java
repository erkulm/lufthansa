package com.erkul.reactive.demo.scheduled;

import com.erkul.reactive.demo.elastic.AirportElasticRepository;
import com.erkul.reactive.demo.elastic.model.AirportESO;
import com.erkul.reactive.demo.entity.NameAndLang;
import com.erkul.reactive.demo.external.model.AirportsResponse;
import com.erkul.reactive.demo.external.service.AirportExtService;
import com.erkul.reactive.demo.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.Set;

@EnableAsync
@RequiredArgsConstructor
@Service
@Slf4j
public class AirportJob {

    private final AirportExtService airportExtService;
    private final AirportRepository airportRepository;
    private final AirportElasticRepository airportElasticRepository;
    private final ModelMapper modelMapper;

    private int offset = 0;

    //@Scheduled(fixedRate = 60000000)
    private void getAirportsAndSave() {
        final Mono<AirportsResponse> allAirports = airportExtService.getAllAirports(100, offset);

        final Flux<com.erkul.reactive.demo.entity.Airport> airportDTOFlux =
                allAirports.flatMapIterable(ac -> ac.getAirportResource().getAirports().getAirport())
                        .map(airport ->
                                com.erkul.reactive.demo.entity.Airport.builder()
                                        .airportCode(airport.getAirportCode())
                                        .cityCode(airport.getCityCode())
                                        .countryCode(airport.getCountryCode())
                                        .utcOffset(airport.getUtcOffset())
                                        .timeZoneId(airport.getTimeZoneId())
                                        .airportNames(getNamesFromExt(airport.getNames()))
                                        .build()
                        );

        airportRepository.insert(airportDTOFlux)
                .flatMap(airport -> airportElasticRepository.save(modelMapper.map(airport, AirportESO.class)))
                .doOnError(throwable -> log.error(throwable.getMessage()))
                .count()
                .subscribe(c -> {
                    if (c > 0) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        offset = offset + c.intValue();
                        getAirportsAndSave();
                    }
                });
    }

    private Set<NameAndLang> getNamesFromExt(com.erkul.reactive.demo.external.model.Names extNames) {
        Set<NameAndLang> names = new HashSet<>();
        extNames.getName().forEach(extName ->
                names.add(NameAndLang.builder()
                        .name(extName.get$())
                        .languageCode(extName.getLanguageCode())
                        .build()));
        return names;
    }
}
