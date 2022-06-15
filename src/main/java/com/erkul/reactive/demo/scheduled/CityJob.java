package com.erkul.reactive.demo.scheduled;

import com.erkul.reactive.demo.external.model.CitiesResponse;
import com.erkul.reactive.demo.external.service.CityExtService;
import com.erkul.reactive.demo.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@EnableAsync
@RequiredArgsConstructor
@Service
@Slf4j
public class CityJob {

    private final CityExtService cityExtService;
    private final CityService cityService;

    @Scheduled(fixedRate = 6000000)
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
        cityService.save(cityDTOFlux);
    }
}
