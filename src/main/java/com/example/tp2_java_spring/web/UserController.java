package com.example.tp2_java_spring.web;

import com.example.tp2_java_spring.entities.User;
import com.example.tp2_java_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/users/{username}")
    public User user (@PathVariable String username){
        User user=userService.findUserByUserName (username);
        return user ;

    }
}
