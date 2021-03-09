package com.medesta.service.impl;

import com.medesta.model.entity.Role;
import com.medesta.model.enums.RoleName;
import com.medesta.repository.RoleRepository;
import com.medesta.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void roleInit() {

        if (roleRepository.count() == 0) {
            Role admin = new Role(RoleName.ADMIN);
            Role receptionist = new Role(RoleName.RECEPTIONIST);
            Role therapist = new Role(RoleName.THERAPIST);
            Role doctor = new Role(RoleName.DOCTOR);

            roleRepository.save(admin);
            roleRepository.save(receptionist);
            roleRepository.save(therapist);
            roleRepository.save(doctor);

        }
    }

    @Override
    public Role findRole(RoleName name) {
        return roleRepository.findByName(name).orElse(null);
    }
}
