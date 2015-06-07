package com.ps.tutorial.hb.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Set;

@Entity @Table(indexes = {
        @Index(name = "idx_fk_address_id", columnList = "address_id"),
        @Index(name = "idx_fk_store_id", columnList = "store_id")
})
public class Staff {

    private int id;
    private String firstName;
    private String lastName;
    private Address address;
    private String username;
    private String password;
    private byte[] picture;
    private String email;
    private Store store;
    private Set<Rental> rentals;
    private boolean isActive;


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "staff_id")
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

    @Column(nullable = false, length = 16)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false, length = 40)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToOne @JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "fk_staff_address"))
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Lob
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Column(length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToOne @JoinColumn(name = "store_id", foreignKey = @ForeignKey(name = "fk_staff_store"))
    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @OneToMany(mappedBy = "staff")
    public Set<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(Set<Rental> rentals) {
        this.rentals = rentals;
    }

    @Column @Type(type = "numeric_boolean")
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", picture=[DIGITAL]" +
                ", email='" + email + '\'' +
                ", store=" + ((store != null) ? store.getId() : "") +
                ", rentals(n)=" + ((rentals != null) ? rentals.size() : "0") +
                ", isActive=" + isActive +
                ", username='" + username + '\'' +
                ", password=[HIDDEN]" +
                '}';
    }
}
