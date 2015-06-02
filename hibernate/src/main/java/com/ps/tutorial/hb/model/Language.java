package com.ps.tutorial.hb.model;

import javax.persistence.*;

@Entity
public class Language {

    private int id;
    private String name;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "language_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
