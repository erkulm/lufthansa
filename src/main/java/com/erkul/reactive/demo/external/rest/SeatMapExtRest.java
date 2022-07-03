package com.erkul.reactive.demo.external.rest;

import com.erkul.reactive.demo.external.model.seatmap.SeatMapResponse;
import com.erkul.reactive.demo.external.service.SeatMapExtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "external/seatmaps")
@RequiredArgsConstructor
public class SeatMapExtRest {
    private final SeatMapExtService seatMapExtService;

    @GetMapping
    public Mono<SeatMapResponse> getSeatMap() {
        return seatMapExtService.getSeatMap("LH1298", "FRA", "IST", "2022-07-14", "M");
    }

    @GetMapping("/string")
    public Mono<String> getCitiesString() {
        return seatMapExtService.getFlightsString(null, "12AUG22", "12AUG22", "FRA", "IST", null);
    }
}
