package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// @Component will let this class bean, @Component create a bean that we can inject in many places
// So if we inject this class in many class we will get same
// instance
// @Service == @Component
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    // @Qualifier are used to specify the class to you want to be used if you have two classes
    // that are using same implementation
    // for example if we put in the parameter @Qualifier("fake")
    // it will use CustomerFakeRepository class
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(
                        () -> new NotFoundException("Customer with id " + id + " not found"));
    }

}
