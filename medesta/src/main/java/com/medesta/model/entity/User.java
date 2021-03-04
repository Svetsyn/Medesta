package com.medesta.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String username;
    //    private String lastName;
//    private String email;
   private String password;
    private List<Role> roles;

    public User() {
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


//    public String getUsername() {
//        return username;
//    }

//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//
//
//
//    @Column(name = "last_name", nullable = false)
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    @Column(name = "email")
//    public String getEmail() {
//        return email;
//    }
//
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany
    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
