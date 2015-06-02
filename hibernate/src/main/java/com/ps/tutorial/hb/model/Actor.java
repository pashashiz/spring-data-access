package com.ps.tutorial.hb.model;

import javax.persistence.*;
import java.util.Set;

@Entity @Table(indexes = @Index(name = "idx_actor_last_name", columnList = "last_name"))
public class Actor {

    private int id;
    private String firstName;
    private String lastName;
    private Set<Film> films;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "actor_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToMany @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "actor_id", foreignKey = @ForeignKey(name = "fk_film_actor_actor")),
            inverseJoinColumns = @JoinColumn(name = "film_id", foreignKey = @ForeignKey(name = "fk_film_actor_film")),
            indexes = @Index(name = "idx_fk_film_id", columnList = "film_id")
    )
    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", films=" + films +
                '}';
    }

}
