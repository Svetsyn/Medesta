package com.medesta.service;

import com.medesta.model.entity.Role;
import com.medesta.model.enums.RoleName;

import java.util.List;

public interface RoleService {
    void roleInit();

    Role findRole(RoleName admin);
}
