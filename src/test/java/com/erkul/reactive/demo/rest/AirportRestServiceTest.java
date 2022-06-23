package com.erkul.reactive.demo.rest;

import com.erkul.reactive.demo.model.AirportDTO;
import com.erkul.reactive.demo.service.impl.AirportServiceImpl;
import com.erkul.reactive.demo.service.model.AirportSearch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@WebFluxTest(AirportRestService.class)
@Import(AirportServiceImpl.class)
class AirportRestServiceTest {
    @Autowired
    WebTestClient webTestClient;

    @MockBean
    AirportServiceImpl airportService;

    AirportDTO airportDTO;

    @BeforeEach
    void setUp() {
        airportDTO = AirportDTO.builder()
                .airportCode("IST")
                .cityCode("IST")
                .countryCode("TR")
                .id(UUID.randomUUID().toString())
                .build();
    }

    @Test
    void getAllCities() {
        given(airportService.getAirports()).willReturn(Flux.just(airportDTO));

        webTestClient.get().uri("/airports")
                .accept(MediaType.APPLICATION_JSON)
                .exchange().expectStatus().isOk()
                .expectBodyList(AirportDTO.class)
                .value(airports -> {
                    assertThat(airports).isNotNull();
                    assertThat(airports).isNotEmpty();
                    assertThat(airports.get(0).getCityCode()).isEqualTo("IST");
                    assertThat(airports.get(0).getAirportCode()).isEqualTo("IST");
                    assertThat(airports.get(0).getCountryCode()).isEqualTo("TR");
                });

        then(airportService).should().getAirports();
    }

    @Test
    void getAirportByCode() {
        given(airportService.searchAirportsByCode(anyString())).willReturn(Mono.just(airportDTO));

        webTestClient.get().uri(uriBuilder -> uriBuilder.path("/airports/get-by-code")
                        .queryParam("code", "IST")
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange().expectStatus().isOk()
                .expectBody(AirportDTO.class)
                .value(airports -> {
                    assertThat(airports).isNotNull();
                    assertThat(airports.getCityCode()).isEqualTo("IST");
                    assertThat(airports.getAirportCode()).isEqualTo("IST");
                    assertThat(airports.getCountryCode()).isEqualTo("TR");
                });

        then(airportService).should().searchAirportsByCode(anyString());
    }

    @Test
    void searchAirports() {
        given(airportService.searchAirports(any(AirportSearch.class))).willReturn(Flux.just(airportDTO));

        webTestClient.method(HttpMethod.GET).uri("/airports/search")
                .body(BodyInserters.fromValue(new AirportSearch("IST", null, null)))
                .accept(MediaType.APPLICATION_JSON)
                .exchange().expectStatus().isOk()
                .expectBodyList(AirportDTO.class)
                .value(airports -> {
                    assertThat(airports).isNotNull();
                    assertThat(airports).isNotEmpty();
                    assertThat(airports.get(0).getCityCode()).isEqualTo("IST");
                    assertThat(airports.get(0).getAirportCode()).isEqualTo("IST");
                    assertThat(airports.get(0).getCountryCode()).isEqualTo("TR");
                });

        then(airportService).should(times(1)).searchAirports(any(AirportSearch.class));
    }
}