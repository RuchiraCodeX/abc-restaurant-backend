package com.example.abc_restaurant.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.abc_restaurant.Models.Services;
import com.example.abc_restaurant.repository.ServicesRepository;

@Service
public class ServicesService {
    
    @Autowired
    private ServicesRepository serviceRepository;

    public List<Services> getAllServices() {
        return serviceRepository.findAll();
    }

    public List<Services> getServicesByCategory(String category) {
        return serviceRepository.findByCategory(category);
    }

    public Services createService(Services service) {
        return serviceRepository.save(service);
    }
    
    public void deleteService(String id) {
        serviceRepository.deleteById(id);
    }
}

