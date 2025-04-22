package com.example.Destideal.entities.city;

import com.example.Destideal.entities.city.model.City;
import com.example.Destideal.entities.city.model.CityDto;
import com.example.Destideal.entities.city.model.CityFilterDto;
import com.example.Destideal.entities.city.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * Método para recuperar una lista de {@link City}
     *
     * @param filterDto un Dto que incluye los filtros.
     * @return {@link List} de {@link CityDto}
     */
    @Operation(summary = "Find", description = "Method that return a List of Cities")
    @RequestMapping(path = "", method = {RequestMethod.POST})
    public List<CityDto> find (@RequestBody(required = false) CityFilterDto filterDto) {

        List<City> listado = cityService.findByTemperatureAndRainfall(filterDto);
        System.out.println(listado.size());
        return listado.stream().map(e -> mapper.map(e, CityDto.class)).collect(Collectors.toList());
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public String funciona(){ return "he conectado";
    }

}



