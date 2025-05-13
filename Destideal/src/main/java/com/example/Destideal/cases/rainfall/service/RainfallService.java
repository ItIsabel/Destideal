package com.example.Destideal.cases.rainfall.service;

import com.example.Destideal.cases.FilterDto;
import com.example.Destideal.cases.rainfall.model.Rainfall;

import java.util.List;

public interface RainfallService {
    List<Rainfall> find(FilterDto filterDto);
}
