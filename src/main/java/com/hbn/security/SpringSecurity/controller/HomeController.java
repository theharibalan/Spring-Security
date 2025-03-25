package com.hbn.security.SpringSecurity.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("hello")
    public String hello(HttpServletRequest request){
        return "Hello World!! " + request.getSession().getId();
    }

    @GetMapping("about")
    public String about(HttpServletRequest request){
        return "Hello about!! "+ request.getSession().getId();
    }

}
