package com.portfolio.dmansuclal.controller;

import com.portfolio.dmansuclal.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Controller for all user related mappings.
 */
@Controller
public class UserController {

    /**
     * Login page mapping for GET requests to /login
     * @param ser the model Attribute
     * @param model the model for user
     * @return login page
     */
    @GetMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

}
