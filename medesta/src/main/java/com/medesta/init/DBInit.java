package com.medesta.init;

import com.medesta.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {


    private final RoleService roleService;
    private final CustomerService customerService;
    private final ProcedureService productService;


    public DBInit(UserService userService, RoleService roleService, CustomerService customerService, ProcedureService productService) {
        this.roleService = roleService;
        this.customerService = customerService;
        this.productService = productService;
    }


    @Override
    public void run(String... args) throws Exception {
        roleService.roleInit();
        customerService.seedCurrentCustomer();
        productService.initAllProcedure();
    }
}
