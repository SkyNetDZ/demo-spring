package com.example.demo.web;

import com.example.demo.domain.Country;
import com.example.demo.domain.CountryRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
public class CountryController {

    private final CountryRepository repository;

    public CountryController(CountryRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/request")
    public Flux<Country> getAll(@RequestParam String name){
        return this.repository.findAllByNameIsStartingWith(name);
    }
}
