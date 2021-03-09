package com.medesta.repository;

import com.medesta.model.entity.Role;
import com.medesta.model.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByName(RoleName roleName);

}
