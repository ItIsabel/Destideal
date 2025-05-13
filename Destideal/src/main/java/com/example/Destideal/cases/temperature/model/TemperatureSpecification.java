package com.example.Destideal.cases.temperature.model;

import org.springframework.data.jpa.domain.Specification;

public class TemperatureSpecification  {

    public static Specification<Temperature> monthTemperatureBetween(String monthProperty, int minRain, int maxRain) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.between(root.get(monthProperty), minRain, maxRain);
        };
    }

}
