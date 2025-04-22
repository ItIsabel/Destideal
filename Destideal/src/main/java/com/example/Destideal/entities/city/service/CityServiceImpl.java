package com.example.Destideal.entities.city.service;

import com.example.Destideal.entities.city.model.City;
import com.example.Destideal.entities.city.model.CityFilterDto;
import com.example.Destideal.entities.rainfall.model.Rainfall;
import com.example.Destideal.entities.rainfall.service.RainfallService;
import com.example.Destideal.entities.temperature.model.Temperature;
import com.example.Destideal.entities.temperature.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
public class CityServiceImpl implements CityService {

    @Autowired
    private RainfallService rainfallService;

    @Autowired
    private TemperatureService temperatureService;


    public List<City> findByTemperatureAndRainfall(CityFilterDto filterDto) {
        List<Rainfall> listaLluvias = this.rainfallService.find(filterDto);
        List<Temperature> listaTemperaturas = this.temperatureService.find(filterDto);

        List<City> ciudades=new ArrayList<>();

        for (Rainfall rainfall : listaLluvias) {
            for (Temperature temperature : listaTemperaturas){
                if (rainfall.getCity().equals(temperature.getCity())) {
                    ciudades.add(rainfall.getCity());
                }
            }
        }

        ciudades.sort(Comparator.comparing(City::getIdCountry));
        return ciudades;
    }
}
