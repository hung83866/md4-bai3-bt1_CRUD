package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping("")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("/login");
        return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView login1(@RequestParam String username,@RequestParam String password){
        ModelAndView modelAndView = null;
        if (username.equals("hungdz")&&password.equals("123456")){
            modelAndView = new ModelAndView("redirect:/product");
            return modelAndView;
        }else {
            modelAndView = new ModelAndView("/login");
            return modelAndView;
        }
    }
}
