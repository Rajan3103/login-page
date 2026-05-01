package com.karthig.loginpage.service;

import com.karthig.loginpage.model.Login;
import com.karthig.loginpage.repo.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public boolean authenticate(String username, String password) {
        Login user = loginRepository.findByUsername(username);
        if (user != null) {
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }
    public Login findByUsername(String username) {
        return loginRepository.findByUsername(username);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = loginRepository.findByUsername(username);
        if (login == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new User(login.getUsername(), login.getPassword(), Collections.emptyList());
    }


    public void saveUser(String username, String rawPassword) {

        if (loginRepository.existsByUsername(username)) {
            throw new RuntimeException("Username already exists");
        }
        Login user = new Login();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(rawPassword));
        loginRepository.save(user);
    }
}
    