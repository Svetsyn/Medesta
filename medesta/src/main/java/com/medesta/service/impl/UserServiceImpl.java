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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final RoleService roleService;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, RoleService roleService, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
        this.currentUser = currentUser;
    }

    @Override
    public UserServiceModel findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {

        User user = modelMapper.map(userServiceModel, User.class);

        user.setPassword(passwordEncoder.encode(userServiceModel.getPassword()));

        user.setEmail(userServiceModel.getEmail());

        Set<Role> roles = new HashSet<>();
        if (userRepository.count() == 0) {
            Role roleAdmin = roleService.findRole(RoleName.ADMIN);
            roles.add(roleAdmin);
            user.setRoles(roles);
        } else {
            Role roleReceptionist = roleService.findRole(RoleName.RECEPTIONIST);
            roles.add(roleReceptionist);
            user.setRoles(roles);
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

//        if (user.getRole().getName() != roleName) {
//            user.setRole(roleService.findRole(roleName));
//        }

        userRepository.save(user);
    }

    @Override
    public void changeRoleNew(String username, RoleName name) {
        User user = userRepository.findByUsername(username).orElse(null);

//        if (user.getRole().getName() !=name){
//            user.setRole(roleService.findRole(name));
//        }

        userRepository.save(modelMapper.map(username, User.class));
    }


}
