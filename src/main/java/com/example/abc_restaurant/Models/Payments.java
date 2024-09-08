package com.example.abc_restaurant.Models;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payments {

    @Id
    private String id;
    private String reservationId;  
    private double amount;
    private String status;  
    private String paymentMethod;  
    private Date paymentDate; 
}

