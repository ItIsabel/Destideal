package com.example.Destideal.cases.city.model;

import com.example.Destideal.cases.country.model.Country;
import com.example.Destideal.cases.rainfall.model.Rainfall;
import com.example.Destideal.cases.temperature.model.Temperature;
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
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country Country;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nameCity) {
        this.name = nameCity;
    }

    public Country getCountry() {
        return Country;
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

