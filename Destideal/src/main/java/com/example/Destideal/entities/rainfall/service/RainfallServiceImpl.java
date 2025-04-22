package com.example.Destideal.entities.rainfall.service;

import com.example.Destideal.entities.city.model.CityFilterDto;
import com.example.Destideal.entities.rainfall.RainfallRepository;
import com.example.Destideal.entities.rainfall.model.Rainfall;
import com.example.Destideal.entities.rainfall.model.RainfallSpecification;
import jakarta.persistence.criteria.JoinType;
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


    public List<Rainfall> find(CityFilterDto filterDto) {
        Specification<Rainfall> spec = RainfallSpecification.monthRainfallBetween(filterDto.getMonth(), filterDto.getMinRain(), filterDto.getMaxRain());

/*
        spec = spec.and((root, query, cb) -> {
            root.fetch("city", JoinType.LEFT);
            return cb.conjunction();
        });
*/

        return rainfallRepository.findAll(spec);
    }

}
