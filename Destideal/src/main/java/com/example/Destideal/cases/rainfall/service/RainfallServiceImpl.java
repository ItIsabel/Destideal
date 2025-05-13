package com.example.Destideal.cases.rainfall.service;

import com.example.Destideal.cases.FilterDto;
import com.example.Destideal.cases.rainfall.RainfallRepository;
import com.example.Destideal.cases.rainfall.model.Rainfall;
import com.example.Destideal.cases.rainfall.model.RainfallSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RainfallServiceImpl implements RainfallService {
    @Autowired
    RainfallRepository rainfallRepository;


    public List<Rainfall> find(FilterDto filterDto) {
        Specification<Rainfall> spec = RainfallSpecification.monthRainfallBetween(filterDto.getMonth(), filterDto.getMinRain(), filterDto.getMaxRain());

        return rainfallRepository.findAll(spec);
    }

}
