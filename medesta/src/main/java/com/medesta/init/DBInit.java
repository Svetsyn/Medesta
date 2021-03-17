package com.medesta.init;

import com.medesta.service.CustomerService;
import com.medesta.service.ProductService;
import com.medesta.service.RoleService;
import com.medesta.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {


    private final RoleService roleService;
    private final CustomerService customerService;
    private final ProductService productService;

    public DBInit(UserService userService, RoleService roleService, CustomerService customerService, ProductService productService) {
        this.roleService = roleService;
        this.customerService = customerService;
        this.productService = productService;
    }


    @Override
    public void run(String... args) throws Exception {
        customerService.seedCurrentCustomer();
        roleService.roleInit();
    }
}
