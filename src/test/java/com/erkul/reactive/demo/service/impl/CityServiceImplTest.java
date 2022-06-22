package com.erkul.reactive.demo.service.impl;

import com.erkul.reactive.demo.elastic.CityElasticRepository;
import com.erkul.reactive.demo.elastic.model.CityESO;
import com.erkul.reactive.demo.entity.City;
import com.erkul.reactive.demo.model.CityDTO;
import com.erkul.reactive.demo.repository.CityRepository;
import com.erkul.reactive.demo.service.model.CitySearch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class CityServiceImplTest {

    @Mock
    CityRepository cityRepository;
    @Mock
    CityElasticRepository cityElasticRepository;
    @Spy
    ModelMapper modelMapper;

    ModelMapper testModelMapper;

    @InjectMocks
    CityServiceImpl cityService;

    City city1;
    City city2;

    CityESO cityESO1;
    CityESO cityESO2;

    CityDTO cityDTO1;
    CityDTO cityDTO2;

    @BeforeEach
    void setUp() {
        testModelMapper = new ModelMapper();
        city1 = new City();
        city1.setCityCode("IST");
        city1.setId(UUID.randomUUID().toString());
        city1.setCountryCode("TR");

        city2 = new City();
        city2.setCityCode("BER");
        city2.setId(UUID.randomUUID().toString());
        city2.setCountryCode("DE");

        cityESO1 = testModelMapper.map(city1, CityESO.class);
        cityESO2 = testModelMapper.map(city2, CityESO.class);

        cityDTO1 = testModelMapper.map(cityESO1, CityDTO.class);
        cityDTO2 = testModelMapper.map(cityESO2, CityDTO.class);
    }

    @Test
    void getCities() {
        final Flux<CityESO> just = Flux.just(cityESO1, cityESO2);
        given(cityElasticRepository.findAll()).willReturn(just);

        final Flux<CityDTO> cityDTOFlux = cityService.getCities();

        StepVerifier.create(cityDTOFlux)
                .expectNextCount(2)
                .verifyComplete();

        StepVerifier.create(cityDTOFlux)
                .expectNext(cityDTO1)
                .expectNext(cityDTO2)
                .verifyComplete();
    }

    @Test
    @MockitoSettings(strictness = Strictness.WARN)
    void save() {

        given(cityRepository.insert(any(Publisher.class))).willReturn(Flux.just(city1, city2));

        given(cityElasticRepository.save(any(CityESO.class)))
                .will((InvocationOnMock invocation) -> Mono.just(cityESO1)
                );

        cityService.save(Flux.just(city1, city2));

        then(cityRepository).should(times(1)).insert(any(Publisher.class));
        then(cityElasticRepository).should(times(2)).save(any(CityESO.class));
    }

    @Test
    void searchCities() {
        given(cityElasticRepository.findAllByCityCodeContains(anyString())).willReturn(Flux.just(cityESO1));

        final Flux<CityDTO> cities = cityService.searchCities("IST");

        StepVerifier.create(cities).expectNext(cityDTO1).verifyComplete();

        StepVerifier.create(cities).expectNextCount(1).verifyComplete();

        then(cityElasticRepository).should(only()).findAllByCityCodeContains(anyString());
    }

    @Test
    void testSearchCities_whenCityCodeIsPresent() {
        given(cityElasticRepository.findAllByCityCodeContains(anyString())).willReturn(Flux.just(cityESO1));
        final Flux<CityDTO> cities = cityService.searchCities(new CitySearch("IST", null));

        StepVerifier.create(cities).expectNext(cityDTO1).verifyComplete();

        StepVerifier.create(cities).expectNextCount(1).verifyComplete();

        then(cityElasticRepository).should(only()).findAllByCityCodeContains(anyString());
    }

    @Test
    void testSearchCities_whenCountryCodeIsPresent() {
        given(cityElasticRepository.findAllByCountryCodeContains(anyString())).willReturn(Flux.just(cityESO1));
        final Flux<CityDTO> cities = cityService.searchCities(new CitySearch(null, "TR"));

        StepVerifier.create(cities).expectNext(cityDTO1).verifyComplete();

        StepVerifier.create(cities).expectNextCount(1).verifyComplete();

        then(cityElasticRepository).should(only()).findAllByCountryCodeContains(anyString());
    }

    @Test
    void testSearchCities_whenCityAndCountryCodesArePresent() {
        given(cityElasticRepository.findAllByCityCodeContainsAndCountryCodeContains(anyString(), anyString())).willReturn(Flux.just(cityESO1));
        final Flux<CityDTO> cities = cityService.searchCities(new CitySearch("IST", "TR"));

        StepVerifier.create(cities).expectNext(cityDTO1).verifyComplete();

        StepVerifier.create(cities).expectNextCount(1).verifyComplete();

        then(cityElasticRepository).should(only()).findAllByCityCodeContainsAndCountryCodeContains(anyString(), anyString());
    }
}