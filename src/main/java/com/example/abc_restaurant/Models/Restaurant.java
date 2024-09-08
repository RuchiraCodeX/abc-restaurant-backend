package com.example.abc_restaurant.Models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "restaurants")
public class Restaurant {
    @Id
    private String id;
    private String name;
    private String address;
    private String description;
    private String imageUrl;
    private String location;
     private List<Dish> menu;
    
   
}


   
   
  
    