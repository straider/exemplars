package com.github.straider;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private Number year;

    @Column(name = "type")
    private String fuel; // TODO: Should it be an enumerated field instead of String?

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "acquiredOn")
    private LocalDate acquiredOn;
    @Column(name = "soldOn")
    private LocalDate soldOn; // TODO: This field can be NULL

    public Vehicle() {
    }

    public Vehicle(
            String     make,
            String     model,
            Number     year,
            String     fuel,
            BigDecimal price,
            LocalDate  acquiredOn,
            LocalDate  soldOn
    ) {
        this.make       = make;
        this.model      = model;
        this.year       = year;
        this.fuel       = fuel;
        this.price      = price;
        this.acquiredOn = acquiredOn;
        this.soldOn     = soldOn;
    }

    // TODO: Getters & Setters should come from Lombok?
    public long getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Number getYear() {
        return year;
    }

    public void setYear(Number year) {
        this.year = year;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String type) {
        this.fuel = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getAcquiredOn() {
        return acquiredOn;
    }

    public void setAcquiredOn(LocalDate acquiredOn) {
        this.acquiredOn = acquiredOn;
    }

    public LocalDate getSoldOn() {
        return soldOn;
    }

    public void setSoldOn(LocalDate soldOn) {
        this.soldOn = soldOn;
    }

    @Override
    public String toString() {
        return "Vehicle: "
             + "id="           + id
             + ", make="       + make
             + ", model="      + model
             + ", year="       + year
             + ", fuel="       + fuel
             + ", price="      + price
             + ", acquiredOn=" + acquiredOn
             + ", soldOn="     + soldOn
        ;
    }

}
