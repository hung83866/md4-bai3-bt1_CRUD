package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Index {
    @GetMapping("")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("redirect:/login");
        return modelAndView;
    }

}
