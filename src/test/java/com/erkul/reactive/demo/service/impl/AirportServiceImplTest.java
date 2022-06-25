package com.erkul.reactive.demo.service.impl;

import com.erkul.reactive.demo.elastic.AirportElasticRepository;
import com.erkul.reactive.demo.elastic.model.AirportESO;
import com.erkul.reactive.demo.entity.Airport;
import com.erkul.reactive.demo.model.AirportDTO;
import com.erkul.reactive.demo.repository.AirportRepository;
import com.erkul.reactive.demo.service.model.AirportSearch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.inOrder;

@ExtendWith(MockitoExtension.class)
class AirportServiceImplTest {

    @Mock
    AirportElasticRepository airportElasticRepository;
    @Mock
    AirportRepository airportRepository;
    @Spy
    ModelMapper modelMapper;
    @InjectMocks
    AirportServiceImpl airportService;

    AirportESO airportESO;
    AirportDTO airportDTO;

    @BeforeEach
    void setUp() {
        airportESO = new AirportESO();
        airportESO.setId(UUID.randomUUID().toString());
        airportESO.setAirportCode("IST");
        airportESO.setCityCode("IST");
        airportESO.setCountryCode("TR");

        airportDTO = modelMapper.map(airportESO, AirportDTO.class);
    }

    @Test
    void getAirports() {
        given(airportElasticRepository.findAll()).willReturn(Flux.just(airportESO));

        final Flux<AirportDTO> airports = airportService.getAirports();
        StepVerifier.create(airports).expectNextCount(1).verifyComplete();
        StepVerifier.create(airports).expectNext(airportDTO).verifyComplete();

        then(airportElasticRepository).should().findAll();
    }

    @Test
    void save() {
        final Airport airport = modelMapper.map(airportDTO, Airport.class);
        given(airportRepository.insert(any(Publisher.class))).willReturn(Flux.just(airport));
        given(airportElasticRepository.save(any(AirportESO.class)))
                .will((InvocationOnMock invocation) -> Mono.just(airportESO)
                );

        airportService.save(Flux.just(airportDTO));


        final InOrder inOrder = inOrder(airportRepository, airportElasticRepository);
        then(airportRepository).should(inOrder).insert(any(Publisher.class));
        then(airportElasticRepository).should(inOrder).save(any());
        then(airportRepository).shouldHaveNoMoreInteractions();
        then(airportElasticRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    void searchAirportsByCode() {
        given(airportElasticRepository.findByAirportCode(anyString())).willReturn(Mono.just(airportESO));

        final Mono<AirportDTO> ist = airportService.searchAirportsByCode("IST");

        StepVerifier.create(ist).expectNextCount(1).verifyComplete();
        StepVerifier.create(ist).expectNext(airportDTO).verifyComplete();

        then(airportElasticRepository).should().findByAirportCode(anyString());
    }

    @Test
    void searchAirports_whenAirportCodeIsPresent() {
        given(airportElasticRepository.findAllByAirportCode(anyString())).willReturn(Flux.just(airportESO));

        final Flux<AirportDTO> ist = airportService.searchAirports(new AirportSearch("IST", null, null));

        StepVerifier.create(ist).expectNextCount(1).verifyComplete();
        StepVerifier.create(ist).expectNext(airportDTO).verifyComplete();

        then(airportElasticRepository).should().findAllByAirportCode(anyString());
    }

    @Test
    void searchAirports_whenCountryCodeIsPresent() {
        given(airportElasticRepository.findAllByCountryCode(anyString())).willReturn(Flux.just(airportESO));

        final Flux<AirportDTO> ist = airportService.searchAirports(new AirportSearch(null, null, "TR"));

        StepVerifier.create(ist).expectNextCount(1).verifyComplete();
        StepVerifier.create(ist).expectNext(airportDTO).verifyComplete();

        then(airportElasticRepository).should().findAllByCountryCode(anyString());
    }

    @Test
    void searchAirports_whenCityAndCountryCodeIsPresent() {
        given(airportElasticRepository.findAllByCityCodeAndCountryCode(anyString(), anyString())).willReturn(Flux.just(airportESO));

        final Flux<AirportDTO> ist = airportService.searchAirports(new AirportSearch(null, "IST", "TR"));

        StepVerifier.create(ist).expectNextCount(1).verifyComplete();
        StepVerifier.create(ist).expectNext(airportDTO).verifyComplete();

        then(airportElasticRepository).should().findAllByCityCodeAndCountryCode(anyString(), anyString());
    }

    @Test
    void searchAirports_whenCityCodeIsPresent() {
        given(airportElasticRepository.findAllByCityCode(anyString())).willReturn(Flux.just(airportESO));

        final Flux<AirportDTO> ist = airportService.searchAirports(new AirportSearch(null, "IST", null));

        StepVerifier.create(ist).expectNextCount(1).verifyComplete();
        StepVerifier.create(ist).expectNext(airportDTO).verifyComplete();

        then(airportElasticRepository).should().findAllByCityCode(anyString());
    }
}