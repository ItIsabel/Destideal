package com.example.Destideal.cases.country.model;

import jakarta.persistence.*;

@Entity
@Table(name = "countries")
public class Country implements Comparable<Country> {
    @Id
    @Column(name = "code")
    private String id;

    @Column(name = "name")
    private String name;

    @Column (name = "continent")
    private String continent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(Country other) {
        return this.getName().compareTo(other.getName());
    }
}
