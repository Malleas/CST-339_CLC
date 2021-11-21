package com.gcu.clc.controller;

import com.gcu.clc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/")

public class RegistrationController {
    @GetMapping("/registration")
    public ModelAndView display() {

        ModelAndView mv = new ModelAndView("registration");
        mv.addObject("title", "Registration Form");
        mv.addObject("user", new User() );
        return mv;


    }

    @PostMapping("/doRegister")
    public String doRegister(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {

        // Check validation errors
        if(bindingResult.hasErrors())
        {
            model.addAttribute("title", "Registration Form");
            return "registration";
        }
        return "login";
    }
}
