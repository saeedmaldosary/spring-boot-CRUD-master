package com.example.demo.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(path = "api/v1/customer")
// This annotation is used at the class level and allows the class to handle the requests made by the client.
// This annotation allows us to send http requests using like @GetMapping etc...
@RestController
// We use @Deprecated to let this class Deprecated and use the other version
@Deprecated
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // We don't have to write value = because it's the default
    @GetMapping(value="all")
    List<Customer> getCustomer() {
        return customerService.getCustomers();
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

    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id) {
        System.out.println("DELETE REQUEST FOR CUSTOMER WITH ID "+id);
    }

}
