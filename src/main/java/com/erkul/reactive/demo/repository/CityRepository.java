package com.erkul.reactive.demo.repository;

import com.erkul.reactive.demo.entity.City;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CityRepository extends ReactiveMongoRepository<City, String> {
    Flux<City> findAllByCityCodeContains(String code);
}
