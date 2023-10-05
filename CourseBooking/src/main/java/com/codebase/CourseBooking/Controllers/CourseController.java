package com.codebase.CourseBooking.Controllers;

import com.codebase.CourseBooking.models.Course;
import com.codebase.CourseBooking.repositories.CourseRepository;
import com.codebase.CourseBooking.types.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public List<Course> getAllCourses(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer rating
    ){
        if(name!= null){
            return courseRepository.findByBookingsCustomerName(name);
        }
        if(rating!=null){
            return courseRepository.findByRating(rating);
        }
        return courseRepository.findAll();
    }


}
