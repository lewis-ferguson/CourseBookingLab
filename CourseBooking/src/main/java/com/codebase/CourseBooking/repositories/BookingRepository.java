package com.codebase.CourseBooking.repositories;

import com.codebase.CourseBooking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {



        @Query("SELECT * FROM booking WHERE date = ")
        List<Booking> SQLdateQuery();
}
