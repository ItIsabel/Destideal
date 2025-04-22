package com.example.Destideal.entities.temperature.model;

import com.example.Destideal.entities.rainfall.model.Rainfall;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serial;

public class TemperatureSpecification  {

    public static Specification<Temperature> monthTemperatureBetween(String monthProperty, int minRain, int maxRain) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.between(root.get(monthProperty), minRain, maxRain);
        };
    }

}
