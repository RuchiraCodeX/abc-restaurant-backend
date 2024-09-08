package com.example.abc_restaurant.Models;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Document(collection = "gallery")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gallery {

    @Id
    private String id;
    private String title;
    private String description;
    private String imageUrl;
    private Date createdAt;
    private Date updatedAt;

}

