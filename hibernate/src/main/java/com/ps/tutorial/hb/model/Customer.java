package com.ps.tutorial.hb.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity @Table(indexes = {
        @Index(name = "idx_fk_address_id", columnList = "address_id"),
        @Index(name = "idx_fk_store_id", columnList = "store_id"),
        @Index(name = "idx_fk_last_name", columnList = "last_name")
})
public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private Store store;
    private Set<Rental> rentals;
    private boolean isActive;
    private Date createDate;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "customer_id")
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

    @Column(length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToOne @JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "fk_customer_address"))
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @ManyToOne @JoinColumn(name = "store_id", foreignKey = @ForeignKey(name = "fk_customer_store"))
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

    @Column(name = "create_date", nullable = false)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", store=" + store +
                ", rentals(n)=" + ((rentals != null) ? rentals.size() : "0") +
                ", isActive=" + isActive +
                ", createDate=" + createDate +
                '}';
    }

}
