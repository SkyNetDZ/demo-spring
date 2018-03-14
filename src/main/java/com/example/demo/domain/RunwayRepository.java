package com.example.demo.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RunwayRepository extends ReactiveCrudRepository<Runway,String> {

    Mono<Runway> findById(String id);

	Flux<Runway> findByAirportRefEquals(int ref);
}
