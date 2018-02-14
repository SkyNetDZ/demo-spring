package com.example.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CountryRepository extends ReactiveCrudRepository <Country,String>{


    Mono<Country> findById(String id);

    Flux<Country> findAll();
}
