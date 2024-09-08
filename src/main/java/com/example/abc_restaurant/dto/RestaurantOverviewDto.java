package com.example.abc_restaurant.dto;

import lombok.Data;
import java.util.List;

@Data
public class RestaurantOverviewDto {
    private String restaurantId;
    private String restaurantName;
    private String restaurantDescription;
    private String restaurantLocation;
    private List<DishDto> dishes;

    public RestaurantOverviewDto(String restaurantId, String restaurantName, String restaurantDescription, String restaurantLocation, List<DishDto> dishes) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.restaurantDescription = restaurantDescription;
        this.restaurantLocation = restaurantLocation;
        this.dishes = dishes;
    }
}

