package com.example.demo.customer;

import java.util.Arrays;
import java.util.List;

// @Repository == @Component
// We will not use @Repository anymore because now we have configuration class.
//@Repository(value = "fake")
public class CustomerFakeRepository implements CustomerRepo {

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "James Bond", "password123"),
                new Customer(2L, "Jamila Ahmed", "password321")
        );
    }
}
