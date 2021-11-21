package com.gcu.clc.controller;

import com.gcu.clc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")

public class RegistrationController {
    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Registration Form");
        model.addAttribute("user", "user");
        return "register";


    }

    @PostMapping("/doRegister")
    public String doRegister(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {

        // Check validation errors
        if(bindingResult.hasErrors())
        {
            model.addAttribute("title", "Registration Form");
            return "register";
        }
        return "login";
    }
}
