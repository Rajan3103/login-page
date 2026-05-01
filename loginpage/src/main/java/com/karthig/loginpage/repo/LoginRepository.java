package com.karthig.loginpage.repo;

import com.karthig.loginpage.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByUsername(String username);
    boolean existsByUsername(String username);

}
