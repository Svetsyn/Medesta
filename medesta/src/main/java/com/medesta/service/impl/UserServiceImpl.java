package com.medesta.service.impl;

import com.medesta.model.entity.Role;
import com.medesta.model.entity.User;
import com.medesta.model.enums.RoleName;
import com.medesta.repository.RoleRepository;
import com.medesta.repository.UserRepository;
import com.medesta.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void seedUserRole() {

        if (roleRepository.count() == 0) {
            Role adminRole = new Role(RoleName.ADMIN);
            Role receptionistRole = new Role(RoleName.RECEPTIONIST);

            roleRepository.save(adminRole);
            roleRepository.save(receptionistRole);


            User adminUser = new User();
            adminUser.setUsername("ADMIN");
            adminUser.setPassword(passwordEncoder.encode("Admin"));
            adminUser.setRoles(List.of(adminRole,receptionistRole));

            User receptionistUser = new User();
            receptionistUser.setUsername("Receptionist");
            receptionistUser.setPassword(passwordEncoder.encode("Receptionist"));
            receptionistUser.setRoles(List.of(receptionistRole));
            userRepository.save(adminUser);

            userRepository.save(adminUser);
            userRepository.save(receptionistUser);
        }

    }
}
