package com.erkul.reactive.demo.elastic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "city")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityESO {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String cityCode;
    String countryCode;
    String utcOffset;
    String timeZoneId;
}