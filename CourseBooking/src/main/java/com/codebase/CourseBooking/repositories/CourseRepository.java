package com.codebase.CourseBooking.repositories;

import com.codebase.CourseBooking.models.Course;
import com.codebase.CourseBooking.types.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

public List<Course> findByBookingsCustomerName(String name);

public List<Course> findByRating(Integer rating);
}
