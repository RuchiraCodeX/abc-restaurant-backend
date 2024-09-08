package com.example.abc_restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.abc_restaurant.Models.Facility;

public interface FacilityRepository extends MongoRepository<Facility, String> {

}
