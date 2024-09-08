package com.example.abc_restaurant.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.abc_restaurant.Models.Dish;
import com.example.abc_restaurant.Models.Restaurant;
import com.example.abc_restaurant.dto.DishDto;
import com.example.abc_restaurant.dto.RestaurantOverviewDto;
import com.example.abc_restaurant.service.DishService;
import com.example.abc_restaurant.service.RestaurantService;


@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final DishService dishService;


    
    public RestaurantController(RestaurantService restaurantService, DishService dishService) {
        this.restaurantService = restaurantService;
        this.dishService = dishService;
    }
     @GetMapping("/search/name")
    public ResponseEntity<List<Restaurant>> searchByName(@RequestParam String name) {
        List<Restaurant> restaurants = restaurantService.searchRestaurantsByName(name);
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/search/dish")
    public ResponseEntity<List<Restaurant>> searchByDishName(@RequestParam String dishName) {
        List<Restaurant> restaurants = restaurantService.searchRestaurantsByDishName(dishName);
        return ResponseEntity.ok(restaurants);
    }
   
    @PostMapping("/add")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant newRestaurant = restaurantService.addRestaurant(restaurant);
        return ResponseEntity.ok(newRestaurant);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable String id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{restaurantId}/overview")
    public RestaurantOverviewDto getRestaurantOverview(@PathVariable String restaurantId) {
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        List<Dish> dishes = dishService.getDishesByRestaurant(restaurantId);

        List<DishDto> dishDtos = dishes.stream()
            .map(dish -> new DishDto(dish.getId(), dish.getName(), dish.getDescription(), dish.getPrice(), dish.getImageUrl()))
            .collect(Collectors.toList());

        return new RestaurantOverviewDto(
            restaurant.getId(),
            restaurant.getName(),
            restaurant.getDescription(),
            restaurant.getLocation(),
            dishDtos
        );
    }
}


