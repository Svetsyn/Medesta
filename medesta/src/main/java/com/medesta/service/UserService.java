package com.medesta.service;

import com.medesta.model.service.UserServiceModel;

import java.util.List;

public interface UserService {


    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void registerUser(UserServiceModel userServiceModel);

    void login(UserServiceModel user);

    void logout();

    List<String> findAllUsername();
}
