package com.example.Destideal.cases;

import com.example.Destideal.cases.country.model.Country;
import com.example.Destideal.cases.country.model.CountryDto;

/**
 * Esta clase sirve para recoger los parámetros enviados por el front para hacer la búsqueda.
 */
public class FilterDto {
    //mes
 private String month;

    //pais
private String country;

    //temperatura
 private int maxTemp;
 private int minTemp;

    //lluvia
 private int maxRain;
 private int minRain;


/*  Implementaciones futuras:
    //interest
 private interest interest;

    //TTOO
    private TTOO ttoo;

    //Precio
    private int price;*/



    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public int getMaxRain() {
        return maxRain;
    }

    public void setMaxRain(int maxRain) {
        this.maxRain = maxRain;
    }

    public int getMinRain() {
        return minRain;
    }

    public void setMinRain(int minRain) {
        this.minRain = minRain;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
