package com.example.abc_restaurant.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {

    @GetMapping("/admin/dashboard")
     @ResponseBody
    public String adminDashboard() {
        return "Admin Dashboard is working!"; 
    }
}

