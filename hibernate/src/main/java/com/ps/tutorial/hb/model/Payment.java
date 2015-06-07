package com.ps.tutorial.hb.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity @Table(indexes = {
        @Index(name = "idx_fk_customer_id", columnList = "customer_id"),
        @Index(name = "idx_fk_staff_id", columnList = "staff_id")
})
public class Payment {

    private int id;
    private Rental rental;
    private Customer customer;
    private Staff staff;
    private BigDecimal amount;
    private Date date;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "payment_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne @JoinColumn(name = "rental_id", foreignKey = @ForeignKey(name = "fk_payment_rental"))
    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    @ManyToOne @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "fk_payment_customer"))
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne @JoinColumn(name = "staff_id", foreignKey = @ForeignKey(name = "fk_payment_staff"))
    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Column(nullable = false)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Column(name = "payment_date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", rental=" + rental +
                ", customer=" + customer +
                ", staff=" + staff +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }

}
