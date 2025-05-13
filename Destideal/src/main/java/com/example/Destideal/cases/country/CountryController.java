package com.example.Destideal.cases.country;

import com.example.Destideal.cases.city.model.City;
import com.example.Destideal.cases.city.model.CityDto;
import com.example.Destideal.cases.FilterDto;
import com.example.Destideal.cases.country.model.Country;
import com.example.Destideal.cases.country.model.CountryDto;
import com.example.Destideal.cases.country.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.*;


/**
 * @author miam
 */
@Tag(name = "Country", description = "API of Country")
@RequestMapping(value = "/countries")
@RestController
@CrossOrigin(origins = "*")
public class CountryController {
    @Autowired
    CountryService countryService;

    @Autowired
    ModelMapper mapper;

    /**
     * Método para recuperar una lista de {@link City}
     *
     * @param filterDto un Dto que incluye los filtros.
     * @return {@link List} de {@link CityDto}
     */
    @Operation(summary = "Find", description = "Method that return a List of Countries")
    @RequestMapping(path = "", method = {RequestMethod.POST})
    public List<CountryDto> find (@RequestBody(required = false) FilterDto filterDto) {
        List<Country> listado =new ArrayList<>();
        listado = countryService.findFilteredCountry(filterDto);
        System.out.println(listado.size());
        return listado.stream().map(e -> mapper.map(e, CountryDto.class)).collect(Collectors.toList());
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public String funciona(){ return "he conectado";
    }

}