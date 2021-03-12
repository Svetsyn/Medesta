package com.medesta.model.service;

import com.medesta.model.entity.Role;
import com.medesta.model.enums.RoleName;

public class RoleServiceModel {

    private Long id;
    private String username;
    private RoleName name;

    public RoleServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}
