package com.example.abc_restaurant.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.abc_restaurant.Models.Gallery;
import com.example.abc_restaurant.repository.GalleryRepository;

@Service
public class GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;

    
    public Gallery addGalleryItem(Gallery gallery) {
        gallery.setCreatedAt(new Date());
        gallery.setUpdatedAt(new Date());
        return galleryRepository.save(gallery);
    }

   
    public Optional<Gallery> getGalleryItemById(String id) {
        return galleryRepository.findById(id);
    }

    
    public List<Gallery> getAllGalleryItems() {
        return galleryRepository.findAll();
    }

    
    public Gallery updateGalleryItem(Gallery gallery) {
        gallery.setUpdatedAt(new Date());
        return galleryRepository.save(gallery);
    }

    
    public void deleteGalleryItem(String id) {
        galleryRepository.deleteById(id);
    }
}

