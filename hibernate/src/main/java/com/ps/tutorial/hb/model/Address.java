package com.ps.tutorial.hb.model;

import javax.persistence.*;

@Entity @Table(indexes = {@Index(name = "idx_fk_city_id", columnList = "city_id")})
public class Address {

    private short id;
    private String fullNameFirst;
    private String fullNameSecond;
    private String distinct;
    private City city;
    private String postalCode;
    private String phone;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "address_id")
    public int getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Column(name = "address", nullable = false, length = 50)
    public String getFullNameFirst() {
        return fullNameFirst;
    }

    public void setFullNameFirst(String fullNameFirst) {
        this.fullNameFirst = fullNameFirst;
    }

    @Column(name = "address1", length = 50)
    public String getFullNameSecond() {
        return fullNameSecond;
    }

    public void setFullNameSecond(String fullNameSecond) {
        this.fullNameSecond = fullNameSecond;
    }

    @Column(name = "distinct", nullable = false, length = 20)
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
