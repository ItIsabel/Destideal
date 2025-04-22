package com.example.Destideal.entities.rainfall.service;

import com.example.Destideal.common.SearchCriteria;
import com.example.Destideal.entities.city.model.CityFilterDto;
import com.example.Destideal.entities.rainfall.RainfallRepository;
import com.example.Destideal.entities.rainfall.model.Rainfall;
import com.example.Destideal.entities.rainfall.model.RainfallSpecification;
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

        RainfallSpecification minRain = new RainfallSpecification(new SearchCriteria(filterDto.getMonth(), ">=", filterDto.getMinRain()));
        RainfallSpecification maxRain = new RainfallSpecification(new SearchCriteria(filterDto.getMonth(), "<=", filterDto.getMaxRain()));

        Specification<Rainfall> spec = Specification.where(minRain).and(maxRain);

        return this.rainfallRepository.findAll(spec);
    }

}
