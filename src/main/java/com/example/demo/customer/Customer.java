package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Customer {

    private final Long id;
    @NotBlank
    private final String name;

    // The difference between @NotBlank and @NotNull is that
    // @NotNull means that the Property must not be null but can be empty
    @NotBlank
    // Below @JsonProperty allows us to send password in API request
    // if we did not use it @JsonIgnore will cause an issue for us
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private final String password;

    @NotBlank
    // @Email will make sure the user has sent email in the request
    // we can add our regular expression in the parameter of @Email
    @Email
    private final String email;



    public Customer(Long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
