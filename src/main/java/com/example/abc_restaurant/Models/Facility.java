package com.example.abc_restaurant.Models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "facilities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facility {
    @Id
    private String id;
    private String name;
    private String imageUrl;
    private String location;
    private String description;

   
}
