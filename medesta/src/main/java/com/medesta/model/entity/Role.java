package com.medesta.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    private RoleName name;


    public Role() {
    }

    @Enumerated(EnumType.STRING)
    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }

}
