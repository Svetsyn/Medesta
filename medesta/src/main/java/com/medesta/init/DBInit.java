package com.medesta.init;

import com.medesta.service.CustomerService;
import com.medesta.service.RoleService;
import com.medesta.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {


    private final RoleService roleService;
    private final CustomerService customerService;

    public DBInit(UserService userService, RoleService roleService, CustomerService customerService) {
        this.roleService = roleService;
        this.customerService = customerService;
    }


    @Override
    public void run(String... args) throws Exception {
        customerService.seedCurrentCustomer();
        roleService.roleInit();
    }
}
