package com.example.Destideal.cases.country.service;

import com.example.Destideal.cases.FilterDto;
import com.example.Destideal.cases.country.model.Country;

import java.util.List;

public interface CountryService {

    public List<Country> findAll();

    public List<Country> findFilteredCountry(FilterDto filterDto);
}
