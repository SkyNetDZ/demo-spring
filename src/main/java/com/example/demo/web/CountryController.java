package com.example.demo.web;

import com.example.demo.domain.*;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import java.util.function.Function;

@RestController
public class CountryController {

    private final CountryRepository countryRepository;
    private final AirportRepository airportRepository;
    private final RunwayRepository runwayRepository;

    public CountryController(CountryRepository countryRepository, AirportRepository airportRepository, RunwayRepository runwayRepository) {
        this.countryRepository = countryRepository;
        this.airportRepository = airportRepository;
        this.runwayRepository = runwayRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/request")
    public Flux<Country> getAll(@RequestParam String name){
        Flux<Country> countries = this.countryRepository.findAllByNameIsStartingWith(name);
        countries.flatMap(country ->
                this.airportRepository.findByIsoCountryEquals(country.getCode())
                        .map(addAirportToCountry(country))
                        .reduce((country1, country2) -> country2)
        );
        return countries;
    }

    private Function<Airport, Country> addAirportToCountry(Country country) {
        return (Airport airport) -> {
            country.addAirport(airport);
            return country;
        };
    }

    @GetMapping("/airports")
    public Flux<Airport> getAllAirports(){
        return this.airportRepository.findByIsoCountryEquals("FR");
    }


}
