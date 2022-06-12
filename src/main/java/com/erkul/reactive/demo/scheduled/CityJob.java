package com.erkul.reactive.demo.scheduled;

import com.erkul.reactive.demo.external.model.CitiesResponse;
import com.erkul.reactive.demo.external.service.CityExtService;
import com.erkul.reactive.demo.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import reactor.core.publisher.Mono;

@EnableAsync
@RequiredArgsConstructor
public class CityJob {

    private final CityExtService cityExtService;
    private final CityService cityService;

    @Scheduled(cron = "45 01 * * 1-2")
    public void getCitiesFromLufthansaAndSaveToDatabase() {
        final Mono<CitiesResponse> allCities = cityExtService.getAllCities();
    }
}
