package com.example.abc_restaurant.Models;





import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "services")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Services {

    @Id
    private String id;
    private String title;
    private String description;
    private String imageUrl; 
    private String category;

  
}
