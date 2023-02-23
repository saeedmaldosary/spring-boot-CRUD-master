package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


// Below two annotations will allow us to map Customer class to our table in the database
@Entity
@Table
@ToString
@AllArgsConstructor
// Below for empty constructor
@NoArgsConstructor
// Below for equals check for example when compare two objects
@EqualsAndHashCode
public class Customer {

    @Id
    private Long id;
    @NotBlank(message = "name must not be empty")
    private String name;

    // The difference between @NotBlank and @NotNull is that
    // @NotNull means that the Property must not be null but can be empty
    @NotBlank(message = "password must not be empty")
    // Below @JsonProperty allows us to send password in API request
    // if we did not use it @JsonIgnore will cause an issue for us
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotBlank(message = "email must not be empty")
    // @Email will make sure the user has sent email in the request
    // we can add our regular expression in the parameter of @Email
    @Email
    private String email;


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

}
