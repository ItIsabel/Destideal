package com.example.Destideal.entities.temperature.service;

import com.example.Destideal.common.SearchCriteria;
import com.example.Destideal.entities.city.model.CityFilterDto;
import com.example.Destideal.entities.temperature.TemperatureRepository;
import com.example.Destideal.entities.temperature.model.Temperature;
import com.example.Destideal.entities.temperature.model.TemperatureSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TemperatureServiceImpl implements TemperatureService{
    @Autowired
    TemperatureRepository temperatureRepository;

    public List<Temperature> find(CityFilterDto filterDto) {

        TemperatureSpecification minTemp = new TemperatureSpecification(new SearchCriteria(filterDto.getMonth(), ">=", filterDto.getMinTemp()));
        TemperatureSpecification maxTemp = new TemperatureSpecification(new SearchCriteria(filterDto.getMonth(), "<=", filterDto.getMaxTemp()));

        Specification<Temperature> spec = Specification.where(minTemp).and(maxTemp);

        return this.temperatureRepository.findAll(spec);
    }

}
