package com.example.abc_restaurant.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.abc_restaurant.Models.Services;

public interface ServicesRepository extends MongoRepository<Services, String> {
    List<Services> findByCategory(String category);

}
