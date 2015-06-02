package com.ps.tutorial.hb.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {

    private int id;
    private String name;
    private Set<Film> films;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "category_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany
    @JoinTable(name = "film_category",
            joinColumns = @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "fk_film_category_category")),
            inverseJoinColumns = @JoinColumn(name = "film_id", foreignKey = @ForeignKey(name = "fk_film_category_film")),
            indexes = @Index(name = "fk_film_category_category", columnList = "category_id")
    )
    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", films=" + films +
                '}';
    }
}
