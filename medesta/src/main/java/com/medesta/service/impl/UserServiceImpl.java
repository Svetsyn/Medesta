package com.medesta.service.impl;

import com.medesta.model.entity.Role;
import com.medesta.model.entity.User;
import com.medesta.model.enums.RoleName;
import com.medesta.model.service.UserServiceModel;
import com.medesta.repository.UserRepository;
import com.medesta.security.CurrentUser;
import com.medesta.service.RoleService;
import com.medesta.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleService roleService;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleService roleService, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
        this.currentUser = currentUser;
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        if (user.getUsername().equals("Svetsyn")) {
            user.setRole(roleService.findRole(RoleName.ADMIN));
        } else {
            user.setRole(roleService.findRole(RoleName.RECEPTIONIST));
        }

        userRepository.save(user);
    }

    @Override
    public void login(UserServiceModel user) {
        currentUser.setId(user.getId());
        currentUser.setUsername(user.getUsername());
        currentUser.setRole(user.getRole().getName());
    }

    @Override
    public void logout() {
        currentUser.setId(null);
        currentUser.setUsername(null);
        currentUser.setRole(null);
    }

    @Override
    public List<String> findAllUsername() {
        return userRepository.findAllUsers();
    }

    @Override
    public void changeRole(String username, RoleName roleName) {


        User user = userRepository.findByUsername(username).orElse(null);

        if (user.getRole().get(0).getName() != roleName) {
            user.setRole(roleService.findRole(roleName));
        }

        userRepository.save(user);
    }

    @Override
    public void changeRoleNew(String username, RoleName name) {
        User user= userRepository.findByUsername(username).orElse(null);

        if (user.getRole().get(0).getName() !=name){
            user.setRole(roleService.findRole(name));
        }

        userRepository.save(modelMapper.map(username,User.class));
    }


}
