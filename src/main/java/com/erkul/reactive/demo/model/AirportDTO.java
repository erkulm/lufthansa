package com.erkul.reactive.demo.model;

import com.erkul.reactive.demo.entity.Names;
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
    Set<Names> cityNames;
    String utcOffset;
    String timeZoneId;
}
