package com.example.demo.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


// @Repository == @Component
// We will not use @Repository anymore because now we have configuration class.
//@Repository
// The Primary are used to let this class the primary if we have to classes
// that are using the same implementation
// (like CustomerRepository class and CustomerFakeRepository class)
// We will not use @Primary anymore because now we have configuration class.
//@Primary
// This class will be used to connect to real database
public class CustomerRepository implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        // Singleton list used to return an immutable list.
        // This list will always contain only one element.
        // When we try to add/remove an element on the returned singleton list,
        // it would give UnsupportedOperationException.
        return Collections.singletonList(
                new Customer(1L, "TODO. Implement real db")

        );
    }
}
