package com.example.Destideal.entities.temperature.service;

import com.example.Destideal.entities.city.model.CityFilterDto;
import com.example.Destideal.entities.rainfall.model.Rainfall;
import com.example.Destideal.entities.rainfall.model.RainfallSpecification;
import com.example.Destideal.entities.temperature.TemperatureRepository;
import com.example.Destideal.entities.temperature.model.Temperature;
import com.example.Destideal.entities.temperature.model.TemperatureSpecification;
import jakarta.persistence.criteria.JoinType;
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
        Specification<Temperature> spec = TemperatureSpecification.monthTemperatureBetween(filterDto.getMonth(), filterDto.getMinTemp(), filterDto.getMaxTemp());
/*
        spec = spec.and((root, query, cb) -> {
            root.fetch("city", JoinType.LEFT);
            return cb.conjunction();
        });
*/
        return temperatureRepository.findAll(spec);
    }

}
