package com.example.abc_restaurant.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.abc_restaurant.Models.Offers;
import com.example.abc_restaurant.repository.OffersRepository;

@Service
public class OffersService {

    @Autowired
    private OffersRepository offersRepository;

    
    public Offers addOffer(Offers offer) {
        offer.setCreatedAt(new Date());
        offer.setUpdatedAt(new Date());
        return offersRepository.save(offer);
    }

    
    public Optional<Offers> getOfferById(String id) {
        return offersRepository.findById(id);
    }
 
    public List<Offers> getAllOffers() {
        return offersRepository.findAll();
    }

    
    public Offers updateOffer(Offers offer) {
        offer.setUpdatedAt(new Date());
        return offersRepository.save(offer);
    }

   
    public void deleteOffer(String id) {
        offersRepository.deleteById(id);
    }
}

