package com.codebase.CourseBooking.models;

import com.codebase.CourseBooking.types.Rating;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
//@Table(name = "course")
public class Course {
    private String name;

    private String town;

    private int rating;

    @OneToMany(mappedBy = "course")
    @JsonIgnoreProperties({"course"})
    private List<Booking> bookings;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Course(String name, String town, Rating rating) {
        this.name = name;
        this.town = town;
        this.rating = rating.getRating();
    }

    public Course() {

    }

    public String getName() {
        return name;
    }

    public String getTown() {
        return town;
    }

    public int getRating() {
        return rating;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setRating(Rating rating) {
        this.rating = rating.getRating();
    }

}
