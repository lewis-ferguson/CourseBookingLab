package com.codebase.CourseBooking.repositories;

import com.codebase.CourseBooking.models.Course;
import com.codebase.CourseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public List<Customer> findByBookingsCourseNameIgnoreCase(String name);

    List<Customer> findByBookingsCourseTownIgnoreCase(String town);
}
