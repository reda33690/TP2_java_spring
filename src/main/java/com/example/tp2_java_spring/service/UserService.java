package com.example.tp2_java_spring.service;

import com.example.tp2_java_spring.entities.Role;
import com.example.tp2_java_spring.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName (String userName) ;
    Role findRoleByRoleName(String roleName);
    void addRoleToUser (String username, String roleName);
    User authenticate(String UserName, String password);
}
