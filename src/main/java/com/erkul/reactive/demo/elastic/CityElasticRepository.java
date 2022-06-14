package com.erkul.reactive.demo.elastic;

import com.erkul.reactive.demo.elastic.model.CityESO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CityElasticRepository extends ReactiveCrudRepository<CityESO, String> {
    Flux<CityESO> findAllByCityCodeContains(String cityCode);

    Flux<CityESO> findAllByCountryCodeContains(String cityCode);

    Flux<CityESO> findAllByCityCodeContainsAndCountryCodeContains(String cityCode, String countryCode);
}
