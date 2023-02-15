package com.example.demo.customer;

import java.util.List;

public interface CustomerRepo {

    // In interface class we should not have any implementation
    List<Customer> getCustomers();

}
