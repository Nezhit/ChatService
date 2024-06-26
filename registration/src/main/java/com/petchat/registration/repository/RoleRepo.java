package com.petchat.registration.repository;

import com.petchat.registration.entity.Role;
import com.petchat.registration.entity.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findRoleByName(ERole role);
}
