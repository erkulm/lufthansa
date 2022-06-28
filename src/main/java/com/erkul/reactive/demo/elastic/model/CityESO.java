package com.erkul.reactive.demo.elastic.model;

import com.erkul.reactive.demo.entity.NameAndLang;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName = "city2")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityESO {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String cityCode;
    @Field(type = FieldType.Text)
    String countryCode;
    @Field(type = FieldType.Nested)
    List<NameAndLang> cityNames;
    String utcOffset;
    String timeZoneId;
}
