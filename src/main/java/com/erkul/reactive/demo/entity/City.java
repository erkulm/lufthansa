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
public class City {
    @Id
    String id;
    String cityCode;
    String countryCode;
    Set<NameAndLang> cityNames;
    String utcOffset;
    String timeZoneId;
}
