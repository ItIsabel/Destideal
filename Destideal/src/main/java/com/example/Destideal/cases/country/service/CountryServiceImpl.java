package com.example.Destideal.cases.country.service;

import com.example.Destideal.cases.city.model.City;
import com.example.Destideal.cases.FilterDto;
import com.example.Destideal.cases.city.service.CityService;
import com.example.Destideal.cases.country.CountryRepository;
import com.example.Destideal.cases.country.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class CountryServiceImpl implements CountryService{
    @Autowired
    CityService cityService;

    @Autowired
    CountryRepository countryRepository;



    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public List<Country> findFilteredCountry(FilterDto filterDto) {
        List<City> listaCiudades = this.cityService.findByTemperatureAndRainfall(filterDto);
        Set<Country> listaPaisesFiltrados = new HashSet<Country>();
        listaCiudades.forEach(city -> listaPaisesFiltrados.add(city.getCountry()));

        return listaPaisesFiltrados.stream().sorted().toList();
    }
}
