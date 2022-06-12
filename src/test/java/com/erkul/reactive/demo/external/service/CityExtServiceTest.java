package com.erkul.reactive.demo.external.service;

import com.erkul.reactive.demo.external.model.CitiesResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CityExtServiceTest {

    @Autowired
    CityExtService cityExtService;

    @Test
    void getAllCities() {
        final Mono<CitiesResponse> allCities = cityExtService.getAllCities();
        allCities.subscribe(System.out::println);
        System.out.println();
        assertThat(allCities).isNotNull();
    }
}