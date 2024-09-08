package com.example.abc_restaurant.dto;

import lombok.Data;

@Data
public class DishDto {
    private String id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;

    public DishDto(String id, String name, String description, double price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}

