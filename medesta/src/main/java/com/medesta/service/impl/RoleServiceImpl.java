package com.medesta.service.impl;

import com.medesta.model.entity.Role;
import com.medesta.model.entity.RoleName;
import com.medesta.repository.RoleRepository;
import com.medesta.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initRole() {
        if (roleRepository.count() == 0) {

            Arrays.stream(RoleName.values()).forEach(roleName -> {
                Role role = new Role(roleName);

                roleRepository.save(role);
            });
        }
    }

    @Override
    public Role findRole(RoleName roleName) {
        return roleRepository.findByName(roleName).orElse(null);
    }
}
