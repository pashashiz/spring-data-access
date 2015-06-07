package com.ps.tutorial.hb.model;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Set;

@Entity @Table(indexes = {@Index(name = "idx_fk_country_id", columnList = "country_id")})
public class City {

    private int id;
    private String name;
    private Country country;
    private Set<Address> addresses;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "city_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @OneToMany(mappedBy = "city", cascade = CascadeType.REMOVE)
    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", addresses(n)=" + ((Hibernate.isInitialized(addresses)) ? addresses.size() : "[LAZY]") +
                '}';
    }
    
}
