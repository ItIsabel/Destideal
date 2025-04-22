package com.example.Destideal.entities.temperature;

import com.example.Destideal.entities.temperature.model.Temperature;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TemperatureRepository extends JpaRepository<Temperature, Long>, JpaSpecificationExecutor<Temperature> {

    @Override
    @EntityGraph(attributePaths = {"city"})
    public List<Temperature> findAll(Specification<Temperature> spec);

}
