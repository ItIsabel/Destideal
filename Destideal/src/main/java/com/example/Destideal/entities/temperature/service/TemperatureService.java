package com.example.Destideal.entities.temperature.service;

import com.example.Destideal.entities.city.model.CityFilterDto;
import com.example.Destideal.entities.temperature.model.Temperature;

import java.util.List;

public interface TemperatureService {
    /**
     * Metodo para encontrar ciudades por temperatura max y min en un mes concreto
     * @param filterDto dto que recoge las peticiones del usuario

     * @return una {@link List} de {@link Temperature}
     */
    List<Temperature> find(CityFilterDto filterDto);
}
