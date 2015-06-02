package com.ps.tutorial.hb.model;

import javax.persistence.*;

@Entity @Table(indexes = {@Index(name = "idx_fk_country_id", columnList = "country_id")})
public class City {

    private int id;
    private String name;
    private Country country;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "city_id")
    public int getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Column(name = "city", length = 50, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne @JoinColumn(name = "country_id", foreignKey = @ForeignKey(name = "fk_city_country"))
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
    
}
