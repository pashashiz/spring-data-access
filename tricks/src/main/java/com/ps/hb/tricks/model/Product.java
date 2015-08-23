package com.ps.hb.tricks.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
public class Product {

    private int id;
    private int version;
    private String name;
    private Double price;
    private BuyOrder order;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @NaturalId
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @OneToOne(mappedBy = "product")
    public BuyOrder getOrder() {
        return order;
    }

    public void setOrder(BuyOrder order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", version=" + version +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
