package com.medesta.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CustomerRegisterBindingModel {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public CustomerRegisterBindingModel() {
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

    @Email(message = "Enter valid email address!")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @NotBlank(message = "This field cannot be empty")
    @Size(min = 5,message = "Phone number must be minimum 5 characters")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
