package com.medesta.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegisterBindingModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;

    public RegisterBindingModel() {
    }
    @NotBlank(message = "This field cannot be empty")
    @Size(min = 3,max = 20,message = "First name must be minimum 3 characters")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @NotBlank(message = "This field cannot be empty")
    @Size(min = 3,max = 20,message = "Last name must be minimum 3 characters")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Email(message = "Email must contains '@'")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
