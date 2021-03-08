package com.medesta.init;

import com.medesta.service.CustomerService;
import com.medesta.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {


    private final UserService userService;
    private final CustomerService customerService;

    public DBInit(UserService userService, CustomerService customerService) {
        this.userService = userService;
        this.customerService = customerService;
    }


    @Override
    public void run(String... args) throws Exception {
        userService.seedUserRole();
        customerService.seedCurrentCustomer();
    }
}
