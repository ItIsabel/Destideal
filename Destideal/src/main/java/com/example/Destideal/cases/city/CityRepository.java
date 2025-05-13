package com.example.Destideal.cases.city;

import com.example.Destideal.cases.city.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CityRepository extends JpaRepository<City,Long>, JpaSpecificationExecutor<City> {

}
