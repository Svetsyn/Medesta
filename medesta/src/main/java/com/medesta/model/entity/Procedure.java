package com.medesta.model.entity;

import com.medesta.model.enums.Office;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "procedures")
public class Procedure extends BaseEntity {
    private String name;
    private String description;
    private Office office;
    private BigDecimal price;
    // Todo try to find appropriate date structure
    private int minutes;
    private Customer customer;

    public Procedure() {
    }

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "minutes", nullable = false)
    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @ManyToOne
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}