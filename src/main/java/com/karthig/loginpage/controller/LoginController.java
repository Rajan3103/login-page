package com.karthig.loginpage.controller;

import com.karthig.loginpage.dto.ApiResponse;
import com.karthig.loginpage.dto.LoginRequest;
import com.karthig.loginpage.model.Login;
import com.karthig.loginpage.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        Login user = loginService.findByUsername(loginRequest.getUsername());

        if (user == null) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Username does not exist"));
        }

        boolean authenticated = loginService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        if (!authenticated) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Incorrect password"));
        }

        return ResponseEntity.ok(new ApiResponse(true, "Login Successful!"));
    }
}
