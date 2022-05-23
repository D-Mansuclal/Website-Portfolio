package com.portfolio.dmansuclal.controller;

import com.portfolio.dmansuclal.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

}
