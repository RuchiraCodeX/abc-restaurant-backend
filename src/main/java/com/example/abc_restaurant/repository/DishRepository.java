package com.example.abc_restaurant.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.abc_restaurant.Models.Dish;

public interface DishRepository extends MongoRepository<Dish, String> {
    List<Dish> findByRestaurantId(String restaurantId); 

}
