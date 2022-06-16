package com.erkul.reactive.demo.rest;

import com.erkul.reactive.demo.elastic.CityElasticRepository;
import com.erkul.reactive.demo.model.CityDTO;
import com.erkul.reactive.demo.repository.CityRepository;
import com.erkul.reactive.demo.service.impl.CityServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;

@WebFluxTest(CityRestService.class)
@Import(CityServiceImpl.class)
class CityRestServiceTest {
    @Autowired
    WebTestClient webTestClient;

    @MockBean
    CityServiceImpl cityService;

    @MockBean
    CityElasticRepository cityElasticRepository;

    @MockBean
    CityRepository cityRepository;

    CityDTO cityDTO;

    @BeforeEach
    void setUp() {
        cityDTO = CityDTO.builder()
                .cityCode("IST")
                .countryCode("TR")
                .id(UUID.randomUUID().toString())
                .build();
    }

    @Test
    void getAllCities() {
        given(cityService.getCities()).willReturn(Flux.just(cityDTO));

        webTestClient.get().uri("/cities")
                .accept(MediaType.APPLICATION_JSON)
                .exchange().expectStatus().isOk()
                .expectBodyList(CityDTO.class)
                .value(cities -> {
                    assertNotNull(cities);
                    assertEquals("IST", cities.get(0).getCityCode());
                    assertEquals("TR", cities.get(0).getCountryCode());
                });
    }

    @Test
    void getCities() {
    }

    @Test
    void testGetCities() {
    }
}