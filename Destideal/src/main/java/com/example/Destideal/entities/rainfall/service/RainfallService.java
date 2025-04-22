package com.example.Destideal.entities.rainfall.service;

import com.example.Destideal.entities.city.model.CityFilterDto;
import com.example.Destideal.entities.rainfall.model.Rainfall;
import org.springframework.data.util.Streamable;

import java.util.List;

public interface RainfallService {
    List<Rainfall> find(CityFilterDto filterDto);
}
