package com.gcu.clc.controller;

import com.gcu.clc.model.LoginModel;
import com.gcu.clc.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/")
    public ModelAndView display(){
        ModelAndView modelAndView = new ModelAndView();
        LoginModel loginModel = new LoginModel();
        modelAndView.addObject("title", "Login Form");
        modelAndView.addObject("loginModel", loginModel);
        modelAndView.setViewName("login");
        return modelAndView;
    }



}
