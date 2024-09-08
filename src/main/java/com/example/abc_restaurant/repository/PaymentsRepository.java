package com.example.abc_restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.abc_restaurant.Models.Payments;

public interface PaymentsRepository extends MongoRepository<Payments, String> {
   
}

