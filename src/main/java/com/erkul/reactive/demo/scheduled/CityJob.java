package com.erkul.reactive.demo.scheduled;

import com.erkul.reactive.demo.entity.City;
import com.erkul.reactive.demo.external.model.CitiesResponse;
import com.erkul.reactive.demo.external.service.CityExtService;
import com.erkul.reactive.demo.model.CityDTO;
import com.erkul.reactive.demo.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@EnableAsync
@RequiredArgsConstructor
@Service
@Slf4j
public class CityJob {

    private final CityExtService cityExtService;
    private final CityService cityService;
    private final ModelMapper modelMapper;

    @Scheduled(fixedRate = 600000)
    public void getCitiesFromLufthansaAndSaveToDatabase() {
        final Mono<CitiesResponse> allCities = cityExtService.getAllCities();

        final Flux<com.erkul.reactive.demo.entity.City> cityDTOFlux =
                allCities.flatMapIterable(ac -> ac.getCityResource().getCities().getCity())
                        .map(city ->
                                com.erkul.reactive.demo.entity.City.builder()
                                        .cityCode(city.getCityCode())
                                        .countryCode(city.getCountryCode())
                                        .utcOffset(city.getUtcOffset())
                                        .build()
                        );
        //TODO subscribe doesn't work why?
        cityDTOFlux
                .subscribe(
                        c -> cityService.saveEntity(modelMapper.map(c, CityDTO.class)).block(),
                        throwable -> log.error(throwable.toString()),
                        () -> log.info("subscription complete")
                ).dispose();
        final Flux<City> save = cityService.save(cityDTOFlux);
        save.blockFirst();
    }
}
