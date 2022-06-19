package com.erkul.reactive.demo.repository;

import com.erkul.reactive.demo.entity.Airport;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface AirportRepository extends ReactiveMongoRepository<Airport, String> {
    Flux<Airport> findAllByAirportCodeContains(String code);
}
