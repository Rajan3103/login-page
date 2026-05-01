package com.karthig.loginpage.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karthig.loginpage.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Optional<Login> findByUsername(String username);
}
