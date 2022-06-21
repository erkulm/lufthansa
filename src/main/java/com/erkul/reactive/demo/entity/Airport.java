package com.erkul.reactive.demo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
@Builder
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airport {
    @Id
    String id;
    String airportCode;
    String cityCode;
    String countryCode;
    Set<Names> airportNames;
    String utcOffset;
    String timeZoneId;
}
