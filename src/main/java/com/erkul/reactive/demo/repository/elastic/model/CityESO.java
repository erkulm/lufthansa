package com.erkul.reactive.demo.repository.elastic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "city")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CityESO {
    @Id
    private String id;
    private String cityCode;
}
