package com.example.Destideal.entities.city.model;

/**
 * Esta clase sirve para recoger los parámetros enviados por el front  para hacer la búsqueda.
 */
public class CityFilterDto {
    //mes
 private String month;

    //temperatura
 private Long maxTemp;
 private Long minTemp;

    //lluvia
 private Long maxRain;
 private Long minRain;


/*  Implementaciones futuras:
    //interest
 private String interest;

    //TTOO
    private String ttoo;

    //Precio
    private int price;*/



    public Long getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Long maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Long getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Long minTemp) {
        this.minTemp = minTemp;
    }

    public Long getMaxRain() {
        return maxRain;
    }

    public void setMaxRain(Long maxRain) {
        this.maxRain = maxRain;
    }

    public Long getMinRain() {
        return minRain;
    }

    public void setMinRain(Long minRain) {
        this.minRain = minRain;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
