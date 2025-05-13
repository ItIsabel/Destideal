package com.example.Destideal.cases.city;

import com.example.Destideal.cases.city.model.City;
import com.example.Destideal.cases.city.model.CityDto;
import com.example.Destideal.cases.FilterDto;
import com.example.Destideal.cases.city.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author miam
 */

@Tag(name = "City", description = "API of City")
@RequestMapping(value = "/cities")
@RestController
@CrossOrigin(origins = "*")
public class CityController {
    @Autowired
    CityService cityService;

    @Autowired
    ModelMapper mapper;
    
    /**
     * Método para recuperar ciudades por país específico
     *
     * @param country El código o ID del país
     * @param filterDto un Dto que incluye filtros adicionales
     * @return {@link List} de {@link CityDto}
     */
    @Operation(summary = "Find by Country", description = "Method that returns a List of Cities filtered by Country")
    @RequestMapping(path = {"","/{id}"}, method = {RequestMethod.POST})
    public List<CityDto> findByCountry(
            @PathVariable("id") String country,
            @RequestBody(required = false) FilterDto filterDto) {
        List<City> listado = cityService.findByCountry(filterDto);
        System.out.println(listado.size());
        return listado.stream().map(e -> mapper.map(e, CityDto.class)).collect(Collectors.toList());
    }
}



