package com.medesta.service;

import com.medesta.model.entity.Role;
import com.medesta.model.enums.RoleName;

public interface RoleService {
    void initRole();

    Role findRole(RoleName roleName);
}
