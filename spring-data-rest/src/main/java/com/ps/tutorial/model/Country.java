package com.ps.tutorial.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Country implements Serializable {

    private int id;
    private String name;

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

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
