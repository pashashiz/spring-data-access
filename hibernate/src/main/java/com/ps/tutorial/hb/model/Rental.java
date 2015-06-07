package com.ps.tutorial.hb.model;

import javax.persistence.*;
import java.util.Date;

@Entity @Table(indexes = {
        @Index(name = "idx_fk_customer_id", columnList = "customer_id"),
        @Index(name = "idx_fk_inventory_id", columnList = "inventory_id"),
        @Index(name = "idx_fk_staff_id", columnList = "staff_id")
})
public class Rental {

    private int id;
    private Inventory inventory;
    private Customer customer;
    private Staff staff;
    private Payment payment;
    private Date rentalDate;
    private Date returnDate;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "rental_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne @JoinColumn(name = "inventory_id", foreignKey = @ForeignKey(name = "fk_rental_inventory"))
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @ManyToOne @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "fk_rental_customer"))
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne @JoinColumn(name = "staff_id", foreignKey = @ForeignKey(name = "fk_rental_staff"))
    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @OneToOne(mappedBy = "rental")
    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Column(nullable = false)
    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    @Column(nullable = false)
    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", inventory=" + inventory +
                ", customer=" + customer +
                ", staff=" + staff +
                ", payment=" + (payment != null) +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                '}';
    }

}
