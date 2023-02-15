package com.example.demo.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Component
// The Primary are used to let this class the primary if we have to classes
// that are using the same implementation
// (like CustomerRepository class and CustomerFakeRepository class)
@Primary
// This class will be used to connect to real database
public class CustomerRepository implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        return Collections.singletonList(
                new Customer(1L, "TODO. Implement real db")

        );
    }
}
