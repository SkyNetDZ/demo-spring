package com.example.web;

import com.example.domain.Country;
import com.example.domain.CountryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
public class CountryController {

    private final CountryRepository repository;

    public CountryController(CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/countries")
    public Flux<Country> getAll(){
        return this.repository.findAll();
    }
}
