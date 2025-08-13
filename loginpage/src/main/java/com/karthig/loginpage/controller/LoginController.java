package com.karthig.loginpage.controller;

import com.karthig.loginpage.model.Login;
import com.karthig.loginpage.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String showLoginForm(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("errorMessage", error);
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {
        Login user = loginService.findByUsername(username);

        if (user == null)
        {
            return "redirect:/login?error=Username does not exist";
        }

        if (!user.getPassword().equals(password))
        {
            return "redirect:/login?error=Incorrect password";
        }

        model.addAttribute("loginSuccess", "Login Successful!");
        return "Welcome";
    }

    @GetMapping("/welcome")
    public String welcome(Model model)
    {
        return "Welcome";
    }
}
