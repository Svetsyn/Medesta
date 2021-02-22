package com.medesta.init;

import com.medesta.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleInitInDB implements CommandLineRunner {

    private final RoleService roleService;

    public RoleInitInDB(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
        roleService.initRole();
    }
}
