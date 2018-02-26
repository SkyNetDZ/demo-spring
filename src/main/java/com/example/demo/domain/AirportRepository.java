package com.example.demo.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AirportRepository extends ReactiveCrudRepository<Airport,String> {

    Mono<Airport> findById(String id);

    Flux<Airport> findAll();

    Flux<Airport> findByIsoCountryEquals(String codeCountry);

    Flux<Airport> findByTypeEquals(String type);

}