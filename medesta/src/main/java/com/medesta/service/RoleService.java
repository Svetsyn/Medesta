package com.medesta.service;

import com.medesta.model.entity.Role;
import com.medesta.model.enums.RoleName;

import java.util.List;
import java.util.Set;

public interface RoleService {
    void roleInit();

    Role findRole(RoleName admin);
}
