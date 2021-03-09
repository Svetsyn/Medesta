package com.medesta.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginBindingModel {

    private String username;
    private String password;

    public LoginBindingModel() {
    }

    @NotBlank(message = "This field cannot be empty")
    @Size(min = 3,max = 20,message = "Username must be minimum 3 characters")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotBlank(message = "This field cannot be empty")
    @Size(min = 5, message = "Password must be minimum 5 characters")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
