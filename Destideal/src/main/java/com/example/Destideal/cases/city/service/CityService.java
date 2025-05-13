package com.example.Destideal.cases.city.service;

import com.example.Destideal.cases.city.model.City;
import com.example.Destideal.cases.FilterDto;

import java.util.List;

public interface CityService {
     List<City> findByTemperatureAndRainfall(FilterDto filterDto);
     List<City> findByCountry(FilterDto filterDto);

}
