package com.example.tp2_java_spring.repositories;

import com.example.tp2_java_spring.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role , Long> {
    Role findRoleByRoleName(String roleName);

}
