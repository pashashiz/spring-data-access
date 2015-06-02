package com.ps.tutorial.hb.model;

import javax.persistence.*;

@Entity
public class Country {

    private short id;
    private String name;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "country_id")
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Column(name = "country", length = 50, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
