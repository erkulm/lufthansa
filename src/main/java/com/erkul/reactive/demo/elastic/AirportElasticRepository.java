package com.erkul.reactive.demo.elastic;

import com.erkul.reactive.demo.elastic.model.AirportESO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AirportElasticRepository extends ReactiveCrudRepository<AirportESO, String> {
    Mono<AirportESO> findByAirportCode(String airportCode);

    Flux<AirportESO> findAllByCityCode(String cityCode);

    Flux<AirportESO> findAllByAirportCode(String cityCode);

    Flux<AirportESO> findAllByCountryCode(String countryCode);

    Flux<AirportESO> findAllByCityCodeAndCountryCode(String cityCode, String countryCode);
}
