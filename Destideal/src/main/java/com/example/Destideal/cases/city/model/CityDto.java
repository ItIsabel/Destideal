package com.example.Destideal.cases.city.model;

import com.example.Destideal.cases.country.model.CountryDto;

/**
 * Esta clase envía los datos al front de la clase Ciudad.
 */
public class CityDto{

private Long id;

private String name;

private CountryDto country;


//getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryDto getCountry() {
        return country;
    }

}
