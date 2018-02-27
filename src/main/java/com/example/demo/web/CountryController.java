package com.example.demo.web;

import com.example.demo.domain.*;
import org.springframework.web.bind.annotation.*;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@RestController
public class CountryController {

    private final AirportRepository airportRepository;
    private final RunwayRepository runwayRepository;
    private final CountryRepository countryRepository;


    public CountryController(CountryRepository countryRepository, AirportRepository airportRepository, RunwayRepository runwayRepository) {
        this.countryRepository = countryRepository;
        this.airportRepository = airportRepository;
        this.runwayRepository = runwayRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/request")
    public Flux<Country> getAll(@RequestParam String name) {
//        Flux<String> flux = (Flux<String>) Flux.just("red", "white", "blue")
//                .log()
//                .map(String::toUpperCase)
//                .subscribe(System.out::println);
        Flux<Country> countries = this.countryRepository.findAllByNameIsStartingWith(name);
        countries.flatMap( country ->
                (Flux<Country>) buildAirports(country)
        );
                        //.reduce((country1, country2) -> country2)
        return countries;
    }

    private Disposable buildAirports(Country country) {
        return this.airportRepository.findByIsoCountryEquals(country.getCode())
        .log()
        .map(a -> a.getName())
        .subscribe(System.out::println);
    }

    private Function<Airport, Country> addAirportToCountry(Country country) {
        return airport -> {
            country.addAirport(airport);
            return country;
        };
    }

    @GetMapping("/airports")
    public Flux<Airport> getAllAirports() {
        return (Flux<Airport>) this.airportRepository.findByIsoCountryEquals("FR").log().map(a -> a.getName()).subscribe(System.out::println);
    }


}
