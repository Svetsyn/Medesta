package com.medesta.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegisterBindingModel {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;

    public RegisterBindingModel() {
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
    @NotBlank(message = "This field cannot be empty")
    @Size(min = 5, message = "Password must be minimum 5 characters")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Email(message = "Enter valid email address!")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
