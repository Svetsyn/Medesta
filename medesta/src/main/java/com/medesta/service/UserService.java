package com.medesta.service;

import com.medesta.model.service.UserServiceModel;

public interface UserService {


    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void registerUser(UserServiceModel userServiceModel);
}
