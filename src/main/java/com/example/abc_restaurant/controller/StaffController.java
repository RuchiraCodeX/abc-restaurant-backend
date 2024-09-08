package com.example.abc_restaurant.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StaffController {

    @GetMapping("/staff/dashboard")
      @ResponseBody
    public String staffDashboard() {
        return "Staff Dashboard is working!"; 
    }
}

