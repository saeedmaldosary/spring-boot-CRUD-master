package com.example.demo.customer;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RequestMapping(path = "api/v2/customers")
// This annotation is used at the class level and allows the class to handle the requests made by the client.
// This annotation allows us to send http requests using like @GetMapping etc...
@RestController
public class CustomerControllerV2 {

    private final CustomerService customerService;

    public CustomerControllerV2(CustomerService customerService) {
        this.customerService = customerService;
    }

    // We don't have to write value = because it's the default
    @GetMapping
    List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping(path = "{customerId}")
    Customer getCustomer(@PathVariable("customerId") Long id) {
        return customerService.getCustomer(id);
    }

    // @RequestBody will allow us to take json payload and map it to Customer object
    @PostMapping()
    void createNewCustomer(@RequestBody Customer customer) {
        System.out.println("POST REQUEST...");
        System.out.println(customer);
    }

    @PutMapping()
    void updateCustomer(@RequestBody Customer customer) {
        System.out.println("UPDATE REQUEST...");
        System.out.println(customer);
    }

    // The difference between @PathVariable and @RequestBody is that
    // @PathVariable from the url and the @RequestBody from the body of the request
    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id) {
        System.out.println("DELETE REQUEST FOR CUSTOMER WITH ID " + id);
    }

}