package com.codebase.CourseBooking.Controllers;

import com.codebase.CourseBooking.models.Customer;
import com.codebase.CourseBooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public List<Customer> getAllCustomers(
            @RequestParam(name = "course" , required = false) String course,
            @RequestParam(name = "town", required = false) String town){
        if(course != null){
            return customerRepository.findByBookingsCourseNameIgnoreCase(course);
        }
        if(town!= null) {
            return customerRepository.findByBookingsCourseTownIgnoreCase(town);
        }
        return customerRepository.findAll();

    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity<Optional<Customer>> getAllCustomers(@PathVariable Long id) {
       return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK) ;

    }



}
