package com.erkul.reactive.demo.repository.elastic;

import com.erkul.reactive.demo.repository.elastic.model.CityESO;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;

public interface CityElasticRepository extends ReactiveElasticsearchRepository<CityESO, String> {
}
