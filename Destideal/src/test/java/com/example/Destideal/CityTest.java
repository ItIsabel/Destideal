package com.example.Destideal;
import com.example.Destideal.entities.city.CityController;
import com.example.Destideal.entities.city.model.City;
import com.example.Destideal.entities.city.model.CityDto;
import com.example.Destideal.entities.city.model.CityFilterDto;
import com.example.Destideal.entities.city.service.CityServiceImpl;
import com.example.Destideal.entities.rainfall.model.Rainfall;
import com.example.Destideal.entities.rainfall.service.RainfallServiceImpl;
import com.example.Destideal.entities.temperature.model.Temperature;
import com.example.Destideal.entities.temperature.service.TemperatureServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


@ExtendWith(MockitoExtension.class)
public class CityTest {
        @Mock
        private CityServiceImpl cityService;

        @Mock
        private ModelMapper mapper;

        @Mock
        private RainfallServiceImpl rainfallService;

        @Mock
        private TemperatureServiceImpl temperatureService;

        @InjectMocks
        private CityController cityController;

        private CityFilterDto filterDto;
        private List<City> cities;
        private List<CityDto> cityDtos;

        private City city1, city2, city3;
        private Rainfall rainfall1, rainfall2, rainfall3;
        private Temperature temperature1, temperature2, temperature3;

        @BeforeEach
        void setUp() {
            // Creamos ciudades para las pruebas
            City city1 = new City();
            city1.setId(1L);
            city1.setName("Madrid");

            City city2 = new City();
            city2.setId(2L);
            city2.setName("Barcelona");

            City city3=new City();
            city3.setId(3L);
            city3.setName("Valencia");

            cities = Arrays.asList(city1, city2, city3);

            // Creamos DTOs correspondientes
            CityDto cityDto1 = new CityDto();
            cityDto1.setId(1L);
            cityDto1.setName("Madrid");

            CityDto cityDto2 = new CityDto();
            cityDto2.setId(2L);
            cityDto2.setName("Barcelona");

            CityDto cityDto3 =new CityDto();
            city3.setId(3L);
            city3.setName("Valencia");

            cityDtos = Arrays.asList(cityDto1, cityDto2, cityDto3);

            // Configuramos el filtro
            filterDto = new CityFilterDto();

            // Crear datos de lluvia
            rainfall1 = new Rainfall();
            rainfall1.setCity(city1);
            rainfall1.setJan(25);
            rainfall1.setFeb(25);
            rainfall1.setMar(25);
            rainfall1.setApr(25);
            rainfall1.setMay(25);
            rainfall1.setJun(25);
            rainfall1.setJul(25);
            rainfall1.setAug(25);
            rainfall1.setSep(25);
            rainfall1.setOct(25);
            rainfall1.setNov(25);
            rainfall1.setDec(25);

            rainfall2 = new Rainfall();
            rainfall2.setCity(city2);
            rainfall2.setJan(25);
            rainfall2.setFeb(25);
            rainfall2.setMar(25);
            rainfall2.setApr(25);
            rainfall2.setMay(25);
            rainfall2.setJun(25);
            rainfall2.setJul(25);
            rainfall2.setAug(25);
            rainfall2.setSep(25);
            rainfall2.setOct(25);
            rainfall2.setNov(25);
            rainfall2.setDec(25);

            rainfall3 = new Rainfall();
            rainfall3.setCity(city3);
            rainfall3.setJan(25);
            rainfall3.setFeb(25);
            rainfall3.setMar(25);
            rainfall3.setApr(25);
            rainfall3.setMay(25);
            rainfall3.setJun(25);
            rainfall3.setJul(25);
            rainfall3.setAug(25);
            rainfall3.setSep(25);
            rainfall3.setOct(25);
            rainfall3.setNov(25);
            rainfall3.setDec(25);

            // Crear datos de temperatura
            temperature1 = new Temperature();
            temperature1.setCity(city1);
            temperature1.setJan(25);
            temperature1.setFeb(25);
            temperature1.setMar(25);
            temperature1.setApr(25);
            temperature1.setMay(25);
            temperature1.setJun(25);
            temperature1.setJul(25);
            temperature1.setAug(25);
            temperature1.setSep(25);
            temperature1.setOct(25);
            temperature1.setNov(25);
            temperature1.setDec(25);


            temperature2 = new Temperature();
            temperature2.setCity(city2);
            temperature2.setJan(25);
            temperature2.setFeb(25);
            temperature2.setMar(25);
            temperature2.setApr(25);
            temperature2.setMay(25);
            temperature2.setJun(25);
            temperature2.setJul(25);
            temperature2.setAug(25);
            temperature2.setSep(25);
            temperature2.setOct(25);
            temperature2.setNov(25);
            temperature2.setDec(25);

            // Configurar el filtro
            filterDto = new CityFilterDto();
        }


        @Test
        public void testFind() {
            // Arrange
            when(cityService.findByTemperatureAndRainfall(filterDto)).thenReturn(cities);

            // Configurar el comportamiento del mapper para cada ciudad
            when(mapper.map(cities.get(0), CityDto.class)).thenReturn(cityDtos.get(0));
            when(mapper.map(cities.get(1), CityDto.class)).thenReturn(cityDtos.get(1));

            // Act
            List<CityDto> result = cityController.find(filterDto);

            // Assert
            assertEquals(3, result.size());
            assertEquals("Madrid", result.get(0).getName());
            assertEquals("Barcelona", result.get(1).getName());

            verify(cityService).findByTemperatureAndRainfall(filterDto);
            verify(mapper, times(3)).map(any(City.class), eq(CityDto.class));
        }

        @Test
        void testFindWithNullFilter() {
            // Arrange
            when(cityService.findByTemperatureAndRainfall(null)).thenReturn(cities);

            // Configurar el comportamiento del mapper para cada ciudad
            when(mapper.map(cities.get(0), CityDto.class)).thenReturn(cityDtos.get(0));
            when(mapper.map(cities.get(1), CityDto.class)).thenReturn(cityDtos.get(1));
            when(mapper.map(cities.get(2), CityDto.class)).thenReturn(cityDtos.get(2));


            // Act
            List<CityDto> result = cityController.find(null);

            // Assert
            assertEquals(3, result.size());

            verify(cityService).findByTemperatureAndRainfall(null);
            verify(mapper, times(3)).map(any(City.class), eq(CityDto.class));
        }

        @Test
        void testFindWithEmptyResult() {
            // Arrange
            when(cityService.findByTemperatureAndRainfall(filterDto)).thenReturn(new ArrayList<>());

            // Act
            List<CityDto> result = cityController.find(filterDto);

            // Assert
            assertTrue(result.isEmpty());

            verify(cityService).findByTemperatureAndRainfall(filterDto);
            verify(mapper, never()).map(any(City.class), eq(CityDto.class));
        }


    @Test
    void testFindByTemperatureAndRainfallWithMatches() {
        // Arrange
        List<Rainfall> rainfallList = Arrays.asList(rainfall1, rainfall2);
        List<Temperature> temperatureList = Arrays.asList(temperature1, temperature2);

        when(rainfallService.find(filterDto)).thenReturn(rainfallList);
        when(temperatureService.find(filterDto)).thenReturn(temperatureList);

        // Act
        List<City> result = cityService.findByTemperatureAndRainfall(filterDto);

        // Assert
        List<City> expected = Arrays.asList(city1, city2);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));

        verify(rainfallService).find(filterDto);
        verify(temperatureService).find(filterDto);
    }
        @Test
        void testFindByTemperatureAndRainfallWithNoMatches() {
            // Arrange
            List<Rainfall> rainfallList = Arrays.asList(rainfall3); // Solo Valencia
            List<Temperature> temperatureList = Arrays.asList(temperature1, temperature2); // Madrid y Barcelona

            when(rainfallService.find(filterDto)).thenReturn(rainfallList);
            when(temperatureService.find(filterDto)).thenReturn(temperatureList);

            // Act
            List<City> result = cityService.findByTemperatureAndRainfall(filterDto);

            // Assert
            assertTrue(result.isEmpty());

            verify(rainfallService).find(filterDto);
            verify(temperatureService).find(filterDto);
        }



        @Test
        void testFindByTemperatureAndRainfallWithDuplicateCities() {
            // Arrange
            // Añadir datos duplicados de lluvia para Madrid
            Rainfall duplicateRainfall = new Rainfall();
            duplicateRainfall.setJul(4);
            duplicateRainfall.setCity(city1);

            List<Rainfall> rainfallList = Arrays.asList(rainfall1, rainfall2, duplicateRainfall);
            List<Temperature> temperatureList = Arrays.asList(temperature1, temperature2);

            when(rainfallService.find(filterDto)).thenReturn(rainfallList);
            when(temperatureService.find(filterDto)).thenReturn(temperatureList);

            // Act
            List<City> result = cityService.findByTemperatureAndRainfall(filterDto);

            // Assert
            assertEquals(2, result.size()); // Debería eliminar duplicados

            verify(rainfallService).find(filterDto);
            verify(temperatureService).find(filterDto);
        }
    }



