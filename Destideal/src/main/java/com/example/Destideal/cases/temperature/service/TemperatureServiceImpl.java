package com.example.Destideal.cases.temperature.service;

import com.example.Destideal.cases.FilterDto;
import com.example.Destideal.cases.temperature.TemperatureRepository;
import com.example.Destideal.cases.temperature.model.Temperature;
import com.example.Destideal.cases.temperature.model.TemperatureSpecification;
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

    public List<Temperature> find(FilterDto filterDto) {
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
