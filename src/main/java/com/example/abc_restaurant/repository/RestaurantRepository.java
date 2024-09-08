package com.example.abc_restaurant.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.abc_restaurant.Models.Restaurant;

public interface RestaurantRepository extends MongoRepository<Restaurant, String> {
    Optional<Restaurant> findByName(String name);
    @Query("{ 'name': { $regex: ?0, $options: 'i' } }")
    List<Restaurant> findByNameContaining(String name);

    @Query("{ 'menu.name': { $regex: ?0, $options: 'i' } }")
    List<Restaurant> findByDishNameContaining(String dishName);
}





