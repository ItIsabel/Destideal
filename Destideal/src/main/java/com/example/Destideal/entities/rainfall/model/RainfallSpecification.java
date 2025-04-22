package com.example.Destideal.entities.rainfall.model;

import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

public class RainfallSpecification {


    public static Specification<Rainfall> monthRainfallBetween(String monthProperty, int minTemp, int maxTemp) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.between(root.get(monthProperty), minTemp, maxTemp);
        };
    }


}
