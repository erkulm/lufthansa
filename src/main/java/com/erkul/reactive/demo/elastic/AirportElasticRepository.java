package com.erkul.reactive.demo.elastic;

import com.erkul.reactive.demo.elastic.model.AirportESO;
import com.erkul.reactive.demo.entity.NameAndLang;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public interface AirportElasticRepository extends ReactiveCrudRepository<AirportESO, String> {
    Mono<AirportESO> findByAirportCode(String airportCode);

    Flux<AirportESO> findAllByCityCode(String cityCode);

    Flux<AirportESO> findAllByAirportCode(String cityCode);

    Flux<AirportESO> findAllByCountryCode(String countryCode);

    Flux<AirportESO> findAllByCityCodeAndCountryCode(String cityCode, String countryCode);

    Flux<AirportESO> findAllByAirportNamesLikeOrAirportCodeStartingWith(String airportNames, String airportCode);

    Flux<AirportESO> findAllByAirportNamesLike(String airportNames);

    Flux<AirportESO> findAllByAirportNamesContainsOrAirportCodeStartingWith(List<NameAndLang> airportNames, String airportCode);
}
