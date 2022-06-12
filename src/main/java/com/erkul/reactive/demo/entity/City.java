package com.erkul.reactive.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
public class City {
    @Id
    String id;
    String cityCode;
    String countryCode;
    Set<CityName> cityNames;
    String utcOffset;
    String timeZoneId;
}
