package com.example.tp2_java_spring.repositories;

import com.example.tp2_java_spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , String> {

    User findUserByUsername(String userName);
}
