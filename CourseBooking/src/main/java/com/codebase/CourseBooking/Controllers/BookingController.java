package com.codebase.CourseBooking.Controllers;

import com.codebase.CourseBooking.models.Booking;
import com.codebase.CourseBooking.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public List<Booking> getAllBookings(
            @RequestParam(required = false)String date
    ){
        if(date!=null){
            return bookingRepository.findByDate(dateX);
        }
        return bookingRepository.findAll();
    }

}
