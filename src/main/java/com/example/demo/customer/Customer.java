package com.example.demo.customer;

public class Customer {

    private final Long id;
    private final String name;

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Below getters methods are using Jackson which JSON processor used for Java
    // If we change getId to getCustomerId it will return for us [{customerId: ........
    // instated of [{id: ......

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
