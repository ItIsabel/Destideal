package com.example.Destideal.cases.city.service;

import com.example.Destideal.cases.city.CityRepository;
import com.example.Destideal.cases.city.model.City;
import com.example.Destideal.cases.FilterDto;
import com.example.Destideal.cases.country.model.Country;
import com.example.Destideal.cases.rainfall.model.Rainfall;
import com.example.Destideal.cases.rainfall.service.RainfallService;
import com.example.Destideal.cases.temperature.model.Temperature;
import com.example.Destideal.cases.temperature.service.TemperatureService;
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

    @Autowired
    private CityRepository cityRepository;

    /**
     * Metodo para filtrar las ciudades por temperatura y precipitaciones medias mensuales
     * @param filterDto contiene los filtros de temperatura y lluvia recibidos del front.
     * @return que devuelve una lista de ciudades en las que se dan una lluvia y temperaturas especificas
     */
    public List<City> findByTemperatureAndRainfall(FilterDto filterDto) {
        List<Rainfall> listaLluvias = this.rainfallService.find(filterDto);
        List<Temperature> listaTemperaturas = this.temperatureService.find(filterDto);

        List<City> ciudades=new ArrayList<>();
//itero la lista de lluvias con la lista de temperaturas, y si existe la ciudad en ambas listas
        for (Rainfall rainfall : listaLluvias) {
            for (Temperature temperature : listaTemperaturas){
                if (rainfall.getCity().equals(temperature.getCity())){
                    ciudades.add(rainfall.getCity());
                }
            }
        }
        return ciudades;
    }

    public List<City> findAll() {
        return this.cityRepository.findAll();
    }

    /**
     * Metodo para obtener ciudades de un pais por temperatura y precipitaciones medias mensuales
     * @param filterDto contiene el código de pais recibido del front.
     * @return una lista de {@link City} de un {@link Country} concreto.
     */
    public List<City>findByCountry(FilterDto filterDto){
    List<City> ciudadesFiltradas= this.findByTemperatureAndRainfall(filterDto);
    List<City> ciudadesFiltradasPorPais= new ArrayList<>();
    for(City city:ciudadesFiltradas){
        if(city.getCountry().getId().equals(filterDto.getCountry())){
            ciudadesFiltradasPorPais.add(city);
        }
    }
    return ciudadesFiltradasPorPais;
}
}