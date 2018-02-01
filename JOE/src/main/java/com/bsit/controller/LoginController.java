package com.bsit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {
	
	@RequestMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }
	
	@RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

}
