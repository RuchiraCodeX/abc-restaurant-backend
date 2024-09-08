package com.example.abc_restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.abc_restaurant.Models.Gallery;

public interface GalleryRepository extends MongoRepository<Gallery, String> {

}
