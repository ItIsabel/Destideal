package com.example.Destideal.entities.city.service;

import com.example.Destideal.entities.city.model.City;
import com.example.Destideal.entities.city.model.CityFilterDto;

import java.util.List;

public interface CityService {
     List<City> findByTemperatureAndRainfall(CityFilterDto filterDto);

    List<City> findAll();
}
