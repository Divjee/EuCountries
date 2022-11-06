package org.example;

public class Country {
    String name;
    Integer population;

    Double area;


    public Country(String name, Integer population, Double area) {

        this.name = name;
        this.population = population;
        this.area = area;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Override
    public String toString() {

        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", area=" + area +
                '}';
    }


}
