package com.example.abc_restaurant.Models;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "Reservations")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Reservation {

    @Id
    private String id;
    private String userID;
    private String serviceType;  
    private String restaurantId;  
    private Date reservationDate;
    private int numberOfGuests;
    private String status; 
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String paymentId;  

   

    
}


