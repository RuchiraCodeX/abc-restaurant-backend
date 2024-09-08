package com.example.abc_restaurant.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.abc_restaurant.Models.Services;
import com.example.abc_restaurant.service.ServicesService;

@RestController
@RequestMapping("/api/services")
public class ServicesController {

    @Autowired
    private ServicesService serviceService;

    @GetMapping("/all")
    public List<Services> getAllServices() {
        return serviceService.getAllServices();
    }

    @GetMapping("/category/{category}")
    public List<Services> getServicesByCategory(@PathVariable String category) {
        return serviceService.getServicesByCategory(category);
    }

    @PostMapping("/add")
    public Services createService(@RequestBody Services service) {
        return serviceService.createService(service);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable String id) {
        serviceService.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}




