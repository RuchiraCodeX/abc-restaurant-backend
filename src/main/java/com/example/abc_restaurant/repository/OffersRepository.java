package com.example.abc_restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.abc_restaurant.Models.Offers;

public interface OffersRepository extends MongoRepository<Offers, String> {

}
