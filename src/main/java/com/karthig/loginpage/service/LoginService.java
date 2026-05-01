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
import java.util.Optional;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

  
    
    public boolean authenticate(String username, String password) {
        Optional<Login> optionalUser = loginRepository.findByUsername(username);
        return optionalUser.isPresent() && passwordEncoder.matches(password, optionalUser.get().getPassword());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Login> optionalLogin = loginRepository.findByUsername(username);
        Login login = optionalLogin.orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new User(login.getUsername(), login.getPassword(), Collections.emptyList());
    }

  
    public String registerUser(String username, String rawPassword) {
        if (loginRepository.findByUsername(username).isPresent()) {
            return "Username already exists";
        }

        Login user = new Login();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(rawPassword)); 
        loginRepository.save(user);
        return "User registered successfully";
    }


    public Login findByUsername(String username) {
        return loginRepository.findByUsername(username).orElse(null);
    }
}
