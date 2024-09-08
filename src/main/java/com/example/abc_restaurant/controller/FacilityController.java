package com.example.abc_restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.abc_restaurant.Models.Facility;
import com.example.abc_restaurant.service.FacilityService;

@RestController
@RequestMapping("/api/facilities")
public class FacilityController {

    @Autowired
    private FacilityService facilityService;

    
    @PostMapping("/add")
    public ResponseEntity<Facility> createOrUpdateFacility(@RequestBody Facility facility) {
        Facility savedFacility = facilityService.saveFacility(facility);
        return ResponseEntity.ok(savedFacility);
    }

   
    @GetMapping("/all")
    public ResponseEntity<List<Facility>> getAllFacilities() {
        List<Facility> facilities = facilityService.getAllFacilities();
        return ResponseEntity.ok(facilities);
    }

  
    @GetMapping("/{id}")
    public ResponseEntity<Facility> getFacilityById(@PathVariable String id) {
        return facilityService.getFacilityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
   
   
    @PutMapping("/update/{id}")
    public ResponseEntity<Facility> updateFacility(@PathVariable String id, @RequestBody Facility facilityDetails) {
        return facilityService.getFacilityById(id).map(facility -> {
            facility.setName(facilityDetails.getName());
            facility.setImageUrl(facilityDetails.getImageUrl());
            facility.setLocation(facilityDetails.getLocation());
            facility.setDescription(facilityDetails.getDescription());
            Facility updatedFacility = facilityService.saveFacility(facility);
            return ResponseEntity.ok(updatedFacility);
        }).orElse(ResponseEntity.notFound().build());
    }

  
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFacility(@PathVariable String id) {
        if (facilityService.getFacilityById(id).isPresent()) {
            facilityService.deleteFacility(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
