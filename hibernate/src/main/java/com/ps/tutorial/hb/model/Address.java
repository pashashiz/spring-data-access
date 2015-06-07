package com.ps.tutorial.hb.model;

import javax.persistence.*;
import java.util.Set;

@Entity @Table(indexes = {@Index(name = "idx_fk_city_id", columnList = "city_id")})
public class Address {

    private int id;
    private String fullNameFirst;
    private String fullNameSecond;
    private String distinct;
    private City city;
    private String postalCode;
    private String phone;
    // Just for cascade removing
    private Set<Store> stores;
    private Set<Staff> staffs;
    private Set<Customer> customers;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "address_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "address", nullable = false, length = 50)
    public String getFullNameFirst() {
        return fullNameFirst;
    }

    public void setFullNameFirst(String fullNameFirst) {
        this.fullNameFirst = fullNameFirst;
    }

    @Column(name = "address2", length = 50)
    public String getFullNameSecond() {
        return fullNameSecond;
    }

    public void setFullNameSecond(String fullNameSecond) {
        this.fullNameSecond = fullNameSecond;
    }

    @Column(name = "district", nullable = false, length = 20)
    public String getDistinct() {
        return distinct;
    }

    public void setDistinct(String distinct) {
        this.distinct = distinct;
    }

    @ManyToOne @JoinColumn(name = "city_id", foreignKey = @ForeignKey(name = "fk_address_city"))
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Column(name = "postal_code", length = 10)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Column(name = "phone", nullable = false, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @OneToMany(mappedBy = "address", cascade = CascadeType.REMOVE)
    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }

    @OneToMany(mappedBy = "address", cascade = CascadeType.REMOVE)
    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }

    @OneToMany(mappedBy = "address", cascade = CascadeType.REMOVE)
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", fullNameFirst='" + fullNameFirst + '\'' +
                ((fullNameSecond != null) ? (", fullNameSecond='" + fullNameSecond + '\'') : "" )+
                ", distinct='" + distinct + '\'' +
                ", city=" + city +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
