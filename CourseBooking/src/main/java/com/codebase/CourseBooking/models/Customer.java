package com.codebase.CourseBooking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Customer {

    private String name;

    private String town;

    private Date dob;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "customer")
    @JsonIgnoreProperties({"customer"})
    private List<Booking> bookings;

    public Customer(String name, String town, Date dob) {
        this.name = name;
        this.town = town;
        this.dob = dob;
        this.bookings = new ArrayList<>();
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public String getTown() {
        return town;
    }

    public Date getDob() {
        return dob;
    }

    public Long getId() {
        return id;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
