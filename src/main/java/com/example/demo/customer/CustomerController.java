package com.example.demo.customer;

import com.example.demo.DemoApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// This annotation is used at the class level and allows the class to handle the requests made by the client.
// This annotation allows us to send http requests using like @GetMapping etc...
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    List<Customer> getCustomer() {
        return customerService.getCustomer();
    }

}
