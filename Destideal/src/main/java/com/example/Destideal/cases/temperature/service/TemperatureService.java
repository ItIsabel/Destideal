package com.example.Destideal.cases.temperature.service;

import com.example.Destideal.cases.FilterDto;
import com.example.Destideal.cases.temperature.model.Temperature;

import java.util.List;

public interface TemperatureService {
    /**
     * Metodo para encontrar ciudades por temperatura max y min en un mes concreto
     * @param filterDto dto que recoge las peticiones del usuario

     * @return una {@link List} de {@link Temperature}
     */
    List<Temperature> find(FilterDto filterDto);
}
