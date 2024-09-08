package com.example.abc_restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.abc_restaurant.Models.Reservation;

public interface ReservationRepository extends MongoRepository<Reservation, String>{

}
