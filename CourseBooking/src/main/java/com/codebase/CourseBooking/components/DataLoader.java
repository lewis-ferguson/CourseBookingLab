package com.codebase.CourseBooking.components;

import com.codebase.CourseBooking.models.Booking;
import com.codebase.CourseBooking.models.Course;
import com.codebase.CourseBooking.models.Customer;
import com.codebase.CourseBooking.repositories.BookingRepository;
import com.codebase.CourseBooking.repositories.CourseRepository;
import com.codebase.CourseBooking.repositories.CustomerRepository;
import com.codebase.CourseBooking.types.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;



    public DataLoader() {
    }

    public void run(ApplicationArguments args) {
//
//        bookingRepository.deleteAll();
//        courseRepository.deleteAll();
//        customerRepository.deleteAll();

        Course course1 = new Course("Codebase", "Edinburgh",Rating.ZERO);
        course1.setRating(Rating.FIVE);
        courseRepository.save(course1);

        Customer customer1 = new Customer("Dawid", "Livingston", new Date(1980 -1900, 4, 19));

        customerRepository.save(customer1);

        Booking booking1 = new Booking(new java.sql.Date(2023- 1900, 10, 5),course1,customer1);
        Booking booking2 = new Booking(new java.sql.Date(2103 - 1900, 1, 19),course1,customer1);
        Booking booking3 = new Booking(new java.sql.Date(1965 - 1900, 3, 28),course1,customer1);
        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking1);
        bookings.add(booking2);
        bookings.add(booking3);
        bookingRepository.saveAll(bookings);

    }
}
