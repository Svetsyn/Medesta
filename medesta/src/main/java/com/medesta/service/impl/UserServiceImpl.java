package com.medesta.service.impl;

import com.medesta.model.entity.RoleName;
import com.medesta.model.entity.User;
import com.medesta.model.service.UserServiceModel;
import com.medesta.repository.UserRepository;
import com.medesta.service.RoleService;
import com.medesta.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleService roleService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User newUser = modelMapper.map(userServiceModel, User.class);

        if (newUser.getFirstName().equals("Svetlin") && newUser.getLastName().equals("Stoyanov")) {
            newUser.setRoles(roleService.findRole(RoleName.ADMIN));
        } else {
            newUser.setRoles(roleService.findRole(RoleName.OTHER));
        }

        userRepository.save(newUser);
    }
}
