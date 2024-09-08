package com.example.abc_restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.abc_restaurant.Models.Gallery;
import com.example.abc_restaurant.service.GalleryService;

@RestController
@RequestMapping("/gallery")
@CrossOrigin(origins = "http://localhost:5173")
public class GalleryController {

    @Autowired
    private GalleryService galleryService;

    
    
   
    @PostMapping("/add")
    public ResponseEntity<Gallery> addGalleryItem(@RequestBody Gallery gallery) {
        Gallery createdGallery = galleryService.addGalleryItem(gallery);
        return ResponseEntity.ok(createdGallery);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Gallery> getGalleryItemById(@PathVariable String id) {
        return galleryService.getGalleryItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

   
    @GetMapping("/all")
    public ResponseEntity<List<Gallery>> getAllGalleryItems() {
        List<Gallery> galleryList = galleryService.getAllGalleryItems();
        return ResponseEntity.ok(galleryList);
    }

   
    @PutMapping("/update/{id}")
    public ResponseEntity<Gallery> updateGalleryItem(@PathVariable String id, @RequestBody Gallery gallery) {
        gallery.setId(id);
        Gallery updatedGallery = galleryService.updateGalleryItem(gallery);
        return ResponseEntity.ok(updatedGallery);
    }

   
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGalleryItem(@PathVariable String id) {
        galleryService.deleteGalleryItem(id);
        return ResponseEntity.noContent().build();
    }
}

