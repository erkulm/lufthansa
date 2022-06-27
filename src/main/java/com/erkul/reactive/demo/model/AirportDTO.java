package com.erkul.reactive.demo.model;

import com.erkul.reactive.demo.entity.NameAndLang;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirportDTO {
    String id;
    String airportCode;
    String cityCode;
    String countryCode;
    Set<NameAndLang> airportNames;
    String utcOffset;
    String timeZoneId;
}
