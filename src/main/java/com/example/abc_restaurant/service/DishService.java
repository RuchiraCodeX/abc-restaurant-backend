package com.example.abc_restaurant.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.abc_restaurant.Models.Dish;
import com.example.abc_restaurant.repository.DishRepository;

@Service
public class DishService {

    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    public List<Dish> getDishesByRestaurant(String restaurantId) {
        return dishRepository.findByRestaurantId(restaurantId);
    }

    public Dish getDishById(String id) {
        return dishRepository.findById(id).orElseThrow(() -> new RuntimeException("Dish not found"));
    }

    public Dish addDish(Dish dish) {
        dish.setCreatedAt(LocalDateTime.now());
        return dishRepository.save(dish);
    }
    

    public Dish updateDish(String id, Dish updatedDish) {
        Dish existingDish = getDishById(id);
        existingDish.setName(updatedDish.getName());
        existingDish.setDescription(updatedDish.getDescription());
        existingDish.setPrice(updatedDish.getPrice());
        existingDish.setImageUrl(updatedDish.getImageUrl());
        return dishRepository.save(existingDish);
    }

    public void deleteDish(String id) {
        dishRepository.deleteById(id);
    }
}
