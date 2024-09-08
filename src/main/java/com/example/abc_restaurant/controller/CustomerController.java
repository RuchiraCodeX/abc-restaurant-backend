package com.example.abc_restaurant.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {

    @GetMapping("/customer/dashboard")
    @ResponseBody  
    public String customerDashboard() {
        return "Customer Dashboard is working!";
    }
}
