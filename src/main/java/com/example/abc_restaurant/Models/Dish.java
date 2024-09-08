package com.example.abc_restaurant.Models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "dishes")
public class Dish {
    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private String restaurantId; 
    private String restaurantName; 
    private LocalDateTime createdAt;
}

