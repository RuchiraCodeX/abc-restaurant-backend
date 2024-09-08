package com.example.abc_restaurant.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.abc_restaurant.Models.Facility;
import com.example.abc_restaurant.repository.FacilityRepository;

@Service
public class FacilityService {

    @Autowired
    private FacilityRepository facilityRepository;

    
    public Facility saveFacility(Facility facility) {
        return facilityRepository.save(facility);
    }

    
    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }

    
    public Optional<Facility> getFacilityById(String id) {
        return facilityRepository.findById(id);
    }

   
    public void deleteFacility(String id) {
        facilityRepository.deleteById(id);
    }
}

