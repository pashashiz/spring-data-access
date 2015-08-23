package com.ps.hb.tricks.model;

import javax.persistence.*;

@Entity @Table(name = "buy_order", indexes = @Index(name = "idx_fk_buy_order_product", columnList = "product_id"))
public class BuyOrder {

    private int id;
    private Product product;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_buy_order_product"))
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product=" + product +
                '}';
    }
}
