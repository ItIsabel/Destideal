package com.example.Destideal.entities.rainfall;

import com.example.Destideal.entities.rainfall.model.Rainfall;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RainfallRepository  extends JpaRepository<Rainfall,Long>, JpaSpecificationExecutor<Rainfall> {

    @EntityGraph(attributePaths = {"city"})
    List<Rainfall> findAll(Specification<Rainfall> spec);

}
