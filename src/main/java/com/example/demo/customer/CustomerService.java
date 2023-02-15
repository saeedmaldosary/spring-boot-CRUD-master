package com.example.demo.customer;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// @Component will let this class bean, @Component create a bean that we can inject in many places
// So if we inject this class in many class we will get same
// instance
@Component
public class CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    List<Customer> getCustomer() {
        return customerRepo.getCustomer();
    }

}
