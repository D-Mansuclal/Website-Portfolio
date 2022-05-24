package com.portfolio.dmansuclal.controller;

import com.portfolio.dmansuclal.model.User;
import com.portfolio.dmansuclal.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller for all user related mappings.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Login page mapping for GET requests to /login
     * @param user the model Attribute
     * @param model the model for user
     * @return login page
     */
    @GetMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    /**
     * Register page mapping for GET requests to /register
     * @param user the model attribute
     * @param model the model for user
     * @return register page
     */
    @GetMapping("/register")
    public String register(@ModelAttribute User user, Model model) {
        model.addAttribute("user", new User());
        return "register";
    }


    /**
     * POST request to register new user using register form.
     * @param user the model attribute
     * @return redirection to login jsp
     */
    @PostMapping("/register-user")
    public String registerUser(@ModelAttribute User user) {
        userService.registerUser(user);
        return "redirect:/login";
    }

}
