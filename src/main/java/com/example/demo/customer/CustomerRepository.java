package com.example.demo.customer;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;


@Component
// This class will be used to connect to real database
public class CustomerRepository implements CustomerRepo {
    @Override
    public List<Customer> getCustomer() {
        return Collections.emptyList();
    }
}
