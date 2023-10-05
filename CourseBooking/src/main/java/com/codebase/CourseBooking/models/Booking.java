package com.codebase.CourseBooking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Booking {

    private Date date;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    @JsonIgnoreProperties({"bookings"})
    private Course course;


    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnoreProperties({"bookings"})
    private Customer customer;

    public Booking(Date date, Course course, Customer customer) {
        this.date = date;
        this.course = course;
        this.customer = customer;
    }

    public Booking() {
    }

    public Date getDate() {
        return date;
    }

    public Long getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Temporal(value = TemporalType.DATE)
    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
