package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class CustomerConfiguration {

    // We can change app.useFakeCustomerRepo value by going to Edit configuration
    // and set the value there
    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

    @Value("${info.company.name}")
    private String companyName;

    @Autowired
    private Environment environment;

    @Bean
        // We use this class when we want to do some setup when the application start
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Command line runner");
            System.out.println(companyName);
            System.out.println(environment.getProperty("info.company.name"));
        };
    }

    // Now we don't have to use the @Qualifier that in CustomerService Class
    // Because we did a configuration here
    @Bean
    CustomerRepo customerRepo() {
        System.out.println("useFakeCustomerRepo = " + useFakeCustomerRepo);
        return new CustomerFakeRepository();
    }

}
