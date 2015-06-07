package com.ps.tutorial.hb.model;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "country.get-by-name", query = "from Country as c where c.name = :name"),
        @NamedQuery(name = "country.get-all", query = "from Country")
})
public class Country {

    private int id;
    private String name;
    private Set<City> cities;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "country_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "country", length = 50, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "country", cascade = CascadeType.REMOVE)
    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cities(n)=" + ((Hibernate.isInitialized(cities)) ? cities.size() : "[LAZY]") +
                '}';
    }

}
