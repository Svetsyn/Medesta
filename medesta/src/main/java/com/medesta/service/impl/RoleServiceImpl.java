package com.medesta.service.impl;

import com.medesta.constant.Constant;
import com.medesta.model.entity.Role;
import com.medesta.model.enums.RoleName;
import com.medesta.repository.RoleRepository;
import com.medesta.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
            admin.setDescription(Constant.ROLE_DESCRIPTION_ADMIN);

            Role receptionist = new Role(RoleName.RECEPTIONIST);
            receptionist.setDescription(Constant.ROLE_DESCRIPTION_RECEPTIONIST);

            Role therapist = new Role(RoleName.THERAPIST);
            therapist.setDescription(Constant.ROLE_DESCRIPTION_THERAPIST);

            Role doctor = new Role(RoleName.DOCTOR);
            doctor.setDescription(Constant.ROLE_DESCRIPTION_DOCTOR);

            Role accountant = new Role((RoleName.ACCOUNTANT));
            accountant.setDescription(Constant.ROLE_ACCOUNTANT);

            roleRepository.saveAll(List.of(admin,receptionist,therapist,doctor,accountant));

        }
    }

    @Override
    public Role findRole(RoleName name) {
        return roleRepository.findByName(name);
    }
}
