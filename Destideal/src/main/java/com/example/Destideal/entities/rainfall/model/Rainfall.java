package com.example.Destideal.entities.rainfall.model;

import com.example.Destideal.entities.city.model.City;
import jakarta.persistence.*;

/**
 * Esta entidad representa las lluvias medias por meses que tiene una ciudad
 * Tiene una relacion identificativa OnetoOne con la entidad {@link City}
 */

@Entity
@Table(name = "rainfalls")
public class Rainfall {

    @Id
    private Long cityId; // Ensure this matches the City's ID type (e.g., Long)

    @OneToOne
    @JoinColumn(name = "id_city")
    @MapsId
    private City city;


    @Column(name = "enero")
    private int jan;

    @Column(name = "febrero")
    private int feb;

    @Column(name = "marzo")
    private int mar;

    @Column(name = "abril")
    private int apr;

    @Column(name = "mayo")
    private int may;

    @Column(name = "junio")
    private int jun;

    @Column(name = "julio")
    private int jul;

    @Column(name = "agosto")
    private int aug;

    @Column(name = "septiembre")
    private int sep;

    @Column(name = "octubre")
    private int oct;

    @Column(name = "noviembre")
    private int nov;

    @Column(name = "diciembre")
    private int dec;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getDec() {
        return dec;
    }

    public void setDec(int dec) {
        this.dec = dec;
    }

    public int getNov() {
        return nov;
    }

    public void setNov(int nov) {
        this.nov = nov;
    }

    public int getOct() {
        return oct;
    }

    public void setOct(int oct) {
        this.oct = oct;
    }

    public int getSep() {
        return sep;
    }

    public void setSep(int sep) {
        this.sep = sep;
    }

    public int getAug() {
        return aug;
    }

    public void setAug(int aug) {
        this.aug = aug;
    }

    public int getJun() {
        return jun;
    }

    public void setJun(int jun) {
        this.jun = jun;
    }

    public int getJul() {
        return jul;
    }

    public void setJul(int jul) {
        this.jul = jul;
    }

    public int getMay() {
        return may;
    }

    public void setMay(int may) {
        this.may = may;
    }

    public int getJan() {
        return jan;
    }

    public void setJan(int jan) {
        this.jan = jan;
    }

    public int getFeb() {
        return feb;
    }

    public void setFeb(int feb) {
        this.feb = feb;
    }

    public int getMar() {
        return mar;
    }

    public void setMar(int mar) {
        this.mar = mar;
    }

    public int getApr() {
        return apr;
    }

    public void setApr(int apr) {
        this.apr = apr;
    }
}
