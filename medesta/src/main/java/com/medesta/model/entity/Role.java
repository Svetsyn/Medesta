package com.medesta.model.entity;

import com.medesta.model.enums.RoleName;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    private RoleName name;
    private String description;


    public Role() {
    }

    public Role(RoleName roleName) {
        this.name = roleName;
    }

    @Column(name = "description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }

}
