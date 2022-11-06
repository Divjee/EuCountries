package org.example;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CountryService {

    CountryRepository repository;

    public CountryRepository getRepository() {
        return repository;
    }

    public void setRepository(CountryRepository repository) {
        this.repository = repository;
    }

    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    public List<Country> getTop10populations(List<Country> countries) {
        return countries.stream().sorted((a, b) -> Integer.compare(b.population, a.population)).limit(10).toList();
    }

    public List<Country> getTop10BiggestArea(List<Country> countries) {
        return countries.stream().filter(i -> !i.area.isNaN()).sorted((a, b) -> Double.compare(b.area, a.area)).limit(10).toList();
    }

    public List<Country> getTopTenDensity(List<Country> countries) {
        return countries.stream().filter(i -> !i.area.isNaN()).sorted((a, b) -> Double.compare(b.population / b.area, a.population / a.area)).limit(10).toList();
    }


}
