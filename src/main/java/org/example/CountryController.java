package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {
    CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return service.getRepository().getCountryList();
    }

    @GetMapping("/countries/top10population")
    public List<Country> getTopTenPopulation() {
        return service.getTop10populations(service.getRepository().getCountryList());
    }

    @GetMapping("/countries/top10highestarea")
    public List<Country> getTopTenAreas() {
        return service.getTop10BiggestArea(service.getRepository().getCountryList());
    }

    @GetMapping("/countries/top10density")
    public List<Country> getTopTenByDensity() {
        return service.getTopTenDensity(service.getRepository().getCountryList());
    }

}
