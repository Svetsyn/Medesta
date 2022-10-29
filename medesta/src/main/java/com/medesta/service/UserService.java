package com.medesta.service;

import com.medesta.model.entity.Role;
import com.medesta.model.entity.User;
import com.medesta.model.enums.RoleName;
import com.medesta.model.service.UserServiceModel;

import java.util.List;

public interface UserService {


//    UserServiceModel findUserByUsernameAndPassword(String username, String password);
    UserServiceModel findUserByUsername(String username);

    void registerUser(UserServiceModel userServiceModel);

    void login(UserServiceModel user);

    void logout();

    List<String> findAllUsername();


    void changeRole(String username, RoleName roleName);

    void changeRoleNew(String username, RoleName name);
}
