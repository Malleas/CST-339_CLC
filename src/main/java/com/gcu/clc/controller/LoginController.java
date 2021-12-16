package com.gcu.clc.controller;

import com.gcu.clc.business.SecurityBusinessService;
import com.gcu.clc.model.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller

public class LoginController {

    @Autowired
    private SecurityBusinessService security;

    @GetMapping("/login")
    public ModelAndView display(){
        ModelAndView modelAndView = new ModelAndView();
        LoginModel loginModel = new LoginModel();
        modelAndView.addObject("title", "Login Form");
        modelAndView.addObject("loginModel", loginModel);
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @PostMapping("doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model){
        ModelAndView modelAndView = new ModelAndView();
        if(bindingResult.hasErrors()){
            modelAndView.addObject("title", "Login Form");
            return "login";
        }
        /**
         * Currently SecurityDataService returns the USER_ID if the username and password match.  We'll use this in the
         * session at some point.
         */
        int loginStatus = security.authenticate(loginModel.getUsername(), loginModel.getPassword());
        if(loginStatus == 0){
            return "login";
        }else {
            return "index";
        }
    }

}
