package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// @Component will let this class bean, @Component create a bean that we can inject in many places
// So if we inject this class in many class we will get same
// instance
// @Service == @Component
@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    // @Qualifier are used to specify the class to you want to be used if you have two classes
    // that are using same implementation
    // for example if we put in the parameter @Qualifier("fake")
    // it will use CustomerFakeRepository class
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    List<Customer> getCustomer() {
        return customerRepo.getCustomers();
    }

}
