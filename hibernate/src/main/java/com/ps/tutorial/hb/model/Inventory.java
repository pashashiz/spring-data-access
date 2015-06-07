package com.ps.tutorial.hb.model;

import javax.persistence.*;

@Entity @Table(indexes = {@Index(name = "idx_fk_film_id", columnList = "store_id")})
public class Inventory {

    private int id;
    private Store store;
    private Film film;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "inventory_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne @JoinColumn(name = "store_id", foreignKey = @ForeignKey(name = "fk_inventory_store"))
    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @ManyToOne @JoinColumn(name = "film_id", foreignKey = @ForeignKey(name = "fk_inventory_film"))
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", store=" + store +
                ", film=" + film +
                '}';
    }

}
