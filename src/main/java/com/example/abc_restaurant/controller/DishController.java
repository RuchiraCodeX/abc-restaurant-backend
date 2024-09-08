package com.example.abc_restaurant.controller;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.abc_restaurant.Models.Dish;
import com.example.abc_restaurant.Models.Restaurant;
import com.example.abc_restaurant.service.DishService;
import com.example.abc_restaurant.service.RestaurantService;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    private final DishService dishService;
    private final RestaurantService restaurantService;

    public DishController(DishService dishService, RestaurantService restaurantService) {
        this.dishService = dishService;
        this.restaurantService = restaurantService;
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/add")
    public ResponseEntity<Dish> addDish(@RequestBody Dish dishRequest) {
        
        Restaurant restaurant = restaurantService.getRestaurantByName(dishRequest.getRestaurantName());
        if (restaurant == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }

       
        Dish dish = new Dish();
        dish.setName(dishRequest.getName());
        dish.setDescription(dishRequest.getDescription());
        dish.setPrice(dishRequest.getPrice());
        dish.setImageUrl(dishRequest.getImageUrl());
        dish.setRestaurantId(restaurant.getId());

        Dish savedDish = dishService.addDish(dish);
        return new ResponseEntity<>(savedDish, HttpStatus.CREATED); 
    }


    @GetMapping("/all")
    public List<Dish> getAllDishes() {
        return dishService.getAllDishes();
    }


     @GetMapping("/{id}")
    public Dish getDishById(@PathVariable String id) {
        return dishService.getDishById(id);
    }

   
    @PutMapping("/update/{id}")
    public Dish updateDish(@PathVariable String id, @RequestBody Dish dish) {
        return dishService.updateDish(id, dish);
    }

   
    @DeleteMapping("/delete/{id}")
    public void deleteDish(@PathVariable String id) {
        dishService.deleteDish(id);
    }

    
}
