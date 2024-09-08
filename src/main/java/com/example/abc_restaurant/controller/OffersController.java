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

import com.example.abc_restaurant.Models.Offers;
import com.example.abc_restaurant.service.OffersService;

@RestController
@RequestMapping("/api/offers")
public class OffersController {

    @Autowired
    private OffersService offersService;

    
    @PostMapping("/add")
    public ResponseEntity<Offers> addOffer(@RequestBody Offers offer) {
        Offers createdOffer = offersService.addOffer(offer);
        return ResponseEntity.ok(createdOffer);
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<Offers> getOfferById(@PathVariable String id) {
        return offersService.getOfferById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

   
    @GetMapping("/all")
    public ResponseEntity<List<Offers>> getAllOffers() {
        List<Offers> offersList = offersService.getAllOffers();
        return ResponseEntity.ok(offersList);
    }

    
    @PutMapping("/update/{id}")
    public ResponseEntity<Offers> updateOffer(@PathVariable String id, @RequestBody Offers offer) {
        offer.setId(id);
        Offers updatedOffer = offersService.updateOffer(offer);
        return ResponseEntity.ok(updatedOffer);
    }

    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable String id) {
        offersService.deleteOffer(id);
        return ResponseEntity.noContent().build();
    }
}

