package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<UserCredentials, Long> {
    UserCredentials findByUsername(String username);

    List<UserCredentials> findAll();
}