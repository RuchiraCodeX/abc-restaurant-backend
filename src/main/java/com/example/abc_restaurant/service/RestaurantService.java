package com.example.abc_restaurant.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.abc_restaurant.Models.Restaurant;
import com.example.abc_restaurant.repository.RestaurantRepository;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant getRestaurantById(String id) {
        return restaurantRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Restaurant not found"));
    }

public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(String id) {
        restaurantRepository.deleteById(id);
    }

    public Restaurant getRestaurantByName(String name) {
        return restaurantRepository.findByName(name)
            .orElseThrow(() -> new RuntimeException("Restaurant with name '" + name + "' not found"));
    }

    public List<Restaurant> searchRestaurantsByName(String name) {
        return restaurantRepository.findByNameContaining(name);
    }

    public List<Restaurant> searchRestaurantsByDishName(String dishName) {
        return restaurantRepository.findByDishNameContaining(dishName);
    }
    

   
}
