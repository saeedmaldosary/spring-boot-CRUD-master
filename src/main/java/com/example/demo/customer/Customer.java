package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {

    private final Long id;
    private final String name;
    private final String password;


    public Customer(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    // Below getters methods are using Jackson which JSON processor used for Java
    // If we change getId to getCustomerId it will return for us [{customerId: ........
    // instated of [{id: ......


    // JSON Property allow us to change the name of the property
    @JsonProperty("customer_id")
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // JsonIgnore allows us to hide a property
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
