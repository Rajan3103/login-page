package com.karthig.loginpage.controller;

import com.karthig.loginpage.dto.ApiResponse;
import com.karthig.loginpage.dto.LoginRequest;
import com.karthig.loginpage.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SignupController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody LoginRequest signupRequest) {

        String result = loginService.registerUser(signupRequest.getUsername(), signupRequest.getPassword());

        if ("Username already exists".equals(result)) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Username already exists"));
        }

        return ResponseEntity.ok(new ApiResponse(true, "Signup Successful!"));
    }
}
