package com.example.Destideal.entities.city.model;

import com.example.Destideal.entities.rainfall.model.Rainfall;
import com.example.Destideal.entities.temperature.model.Temperature;
import jakarta.persistence.*;

/**
 * Esta entidad representa una ciudad, que tiene como atributos:
 *  - identificador de ciudad,
 *  - nombre,
 *  - identificador de pais
 *  - nombre de país.
 *
 * Tiene una relacion identificativa OnetoOne con la entidad {@link Rainfall}
 * y una relacion identificativa OnetoOne con la entidad {@link Temperature}
 */

@Entity
@Table(name = "cities")
public class City {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String nameCity;

    @Column(name = "id_country")
    private String idCountry;

    @Column(name = "country")
    private String nameCountry;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return nameCity;
    }

    public void setName(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(String idCountry) {
        this.idCountry = idCountry;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

/*    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City city = (City) obj;
        return id != null && id.equals(city.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }*/
}

