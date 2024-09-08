package com.example.abc_restaurant.Models;



import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "offers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offers {

    @Id
    private String id;
    private String title;
    private String description;
    private double discountPercentage;
    private Date validFrom;
    private Date validUntil;
    private String imageUrl; 
    private Date createdAt;
    private Date updatedAt;

  
}
