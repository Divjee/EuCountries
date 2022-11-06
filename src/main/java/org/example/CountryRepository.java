package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class CountryRepository {

    private List<Country> countryList ;

    public CountryRepository(List<Country> countryList) {
        this.countryList= getCountryListTextFile();
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public List<Country> getCountryListTextFile() {
        List<Country> list = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader("output.txt"));
            String line;
            JSONArray jsonArray = null;
            while ((line = br.readLine()) != null) {
                jsonArray = new JSONArray(line);
            }
            list = new ArrayList<>();
            for (int i = 0; i < Objects.requireNonNull(jsonArray).length(); i++) {
                JSONObject someCountry = (JSONObject) jsonArray.get(i);
                list.add(new Country(someCountry.getString("name"), someCountry.getInt("population"), someCountry.optDouble("area")));
            }
            br.close();
            return list;
        } catch (IOException e) {
            System.out.println("Notika kļūda!");
            return list;
        }
    }
}
