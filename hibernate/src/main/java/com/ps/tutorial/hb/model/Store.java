package com.ps.tutorial.hb.model;

import javax.persistence.*;

@Entity @Table(indexes = @Index(name = "idx_fk_address_id", columnList = "address_id"))
public class Store {

    private int id;
    private Address address;
    private Staff manager;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "store_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne @JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "fk_store_address"))
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @OneToOne @JoinColumn(name = "manager_staff_id", foreignKey = @ForeignKey(name = "fk_store_staff"))
    public Staff getManager() {
        return manager;
    }

    public void setManager(Staff manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", address=" + address +
                ", manager=" + manager +
                '}';
    }

}
