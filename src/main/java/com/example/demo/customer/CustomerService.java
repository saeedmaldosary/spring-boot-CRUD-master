package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// @Component will let this class bean, @Component create a bean that we can inject in many places
// So if we inject this class in many class we will get same
// instance
// @Service == @Component
@Service
public class CustomerService {
    // Logger is an interface( Best thing about an interface is we can switch logging interface)
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;

    // @Qualifier are used to specify the class to you want to be used if you have two classes
    // that are using same implementation
    // for example if we put in the parameter @Qualifier("fake")
    // it will use CustomerFakeRepository class
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    List<Customer> getCustomers() {
        LOGGER.info("getCustomer was called");
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(
                () -> {
                    NotFoundException notFoundException = new NotFoundException("Customer with id " + id + " not found");
                    LOGGER.error("error in getting customer {}", id, notFoundException);
                    return notFoundException;
                });
    }

}
