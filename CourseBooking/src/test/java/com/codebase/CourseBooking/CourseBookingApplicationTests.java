package com.codebase.CourseBooking;

import com.codebase.CourseBooking.models.Booking;
import com.codebase.CourseBooking.models.Course;
import com.codebase.CourseBooking.models.Customer;
import com.codebase.CourseBooking.repositories.BookingRepository;
import com.codebase.CourseBooking.repositories.CourseRepository;
import com.codebase.CourseBooking.repositories.CustomerRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
class CourseBookingApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void customerHasBookings() {
		Customer customer10 = new Customer("David", "Krakow", new Date(1565-1900, 8, 10));
		Course course = new Course("CodeBase", "Fife");
		Booking booking = new Booking(new Date(2000-1900, 6,9), course, customer10);

		customer10.getBookings().add(booking);

		Assert.assertEquals(booking, customer10.getBookings().get(0));


	}


}
