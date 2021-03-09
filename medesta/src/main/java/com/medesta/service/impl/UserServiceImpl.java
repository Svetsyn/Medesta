package com.medesta.service.impl;

import com.medesta.model.entity.User;
import com.medesta.model.enums.RoleName;
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
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password)
                .map(user -> modelMapper.map(user,UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user =modelMapper.map(userServiceModel, User.class);
        if (user.getUsername().equals("Svetsyn")){
            user.setRole(roleService.findRole(RoleName.ADMIN));
        }else {
            user.setRole(roleService.findRole(RoleName.RECEPTIONIST));
        }

        userRepository.save(user);
    }
}
