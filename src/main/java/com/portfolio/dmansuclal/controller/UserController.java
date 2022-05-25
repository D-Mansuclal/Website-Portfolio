package com.portfolio.dmansuclal.controller;

import java.security.Principal;

import javax.validation.Valid;

import com.portfolio.dmansuclal.model.User;
import com.portfolio.dmansuclal.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
     * @return login page or redirect to home page if a user is logged in
     */
    @GetMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("user", new User());

        if (principal == null || principal instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        return "redirect:/";
    }

    /**
     * Register page mapping for GET requests to /register
     * @param user the model attribute
     * @param model the model for user
     * @return register page or redirect to home page if a user is logged in
     */
    @GetMapping("/register")
    public String register(@ModelAttribute User user, Model model) {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("user", new User());
        
        if (principal == null || principal instanceof AnonymousAuthenticationToken) {
            return "register";
        }
        return "redirect:/";
    }

    /**
     * POST request to register new user using register form.
     * @param user the model attribute
     * @param result the error checking for validation
     * @return redirection to login page if user registered successfully, or 
     * register page with errors if register page contained errors
     */
    @PostMapping("/register-user")
    public String registerUser(@Valid @ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }

        userService.registerUser(user);
        return "redirect:/login";
    }

}
