package com.medesta.init;

import com.medesta.service.ProcedureService;
import com.medesta.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final RoleService roleService;
    private final ProcedureService procedureService;

    public DBInit(RoleService roleService, ProcedureService procedureService) {
        this.roleService = roleService;
        this.procedureService = procedureService;
    }

    @Override
    public void run(String... args) throws Exception {
        roleService.initRole();
        procedureService.initAllProcedure();
    }
}
