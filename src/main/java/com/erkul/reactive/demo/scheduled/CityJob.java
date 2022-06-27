package com.erkul.reactive.demo.scheduled;

import com.erkul.reactive.demo.elastic.CityElasticRepository;
import com.erkul.reactive.demo.elastic.model.CityESO;
import com.erkul.reactive.demo.external.model.CitiesResponse;
import com.erkul.reactive.demo.external.service.CityExtService;
import com.erkul.reactive.demo.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@EnableAsync
@RequiredArgsConstructor
@Service
@Slf4j
public class CityJob {

    private final CityExtService cityExtService;
    private final CityRepository cityRepository;
    private final CityElasticRepository cityElasticRepository;
    private final ModelMapper modelMapper;

    private int offset = 0;

    //@Scheduled(fixedRate = 6000000)
    private void getCitiesAndSave() {
        final Mono<CitiesResponse> allCities = cityExtService.getAllCities(100, offset);

        final Flux<com.erkul.reactive.demo.entity.City> cityDTOFlux =
                allCities.flatMapIterable(ac -> ac.getCityResource().getCities().getCity())
                        .map(city ->
                                com.erkul.reactive.demo.entity.City.builder()
                                        .cityCode(city.getCityCode())
                                        .countryCode(city.getCountryCode())
                                        .utcOffset(city.getUtcOffset())
                                        .build()
                        );

        cityRepository.insert(cityDTOFlux)
                .flatMap(city -> cityElasticRepository.save(modelMapper.map(city, CityESO.class)))
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
                        getCitiesAndSave();
                    }
                });
    }
}
