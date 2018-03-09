package com.example.demo.web;

import com.example.demo.domain.*;

import jdk.nashorn.internal.runtime.logging.DebugLogger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        Flux<Country> countries = this.countryRepository.findAllByNameIsStartingWith(name);
        return countries.flatMap(c ->
                airportRepository.findByIsoCountryEquals(c.getCode()).map(addAirportToCountry(c)).reduce(((country, country2) -> country2))
        );
    }


    private Function<Airport, Country> addAirportToCountry(Country country) {
        return airport -> {
            country.addAirport(runwayRepository.findByAirportIdentEquals(airport.getIdent()).map(addRunwayToAirport(airport)).reduce((airport1, airport2) -> airport2).block());
            return country;
        };
    }

    private Function<Runway, Airport> addRunwayToAirport(Airport airport) {
        return runway -> {
            airport.addRunway(runway);
            return airport;
        };
    }

    @GetMapping("/airports")
    public Flux<Airport> getAllAirports() {
        return (Flux<Airport>) this.airportRepository.findByIsoCountryEquals("FR").log().map(a -> a.getName()).subscribe(System.out::println);
    }

    @GetMapping("/runways")
    public Flux<Runway> getAllRunways() {
        return this.runwayRepository.findByAirportIdentEquals("NFTE");
    }


}
