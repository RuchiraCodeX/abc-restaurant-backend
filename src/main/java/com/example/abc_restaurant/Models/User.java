package com.example.abc_restaurant.Models;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {



    @Id
    private String id;
    private String userID;

    @NotBlank(message ="Username is required")
    @Size(min = 3, max = 30, message = "Username must be between 3 and 30 characters")
    private String username;

    @NotBlank(message ="Password is required")
    @Size(min = 6, max = 100, message = "Password must be between 6 and 100 characters")
    private String password;

    @NotBlank(message ="Role is required")
    private String role;

    @Email(message ="Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;
    private boolean active;
    private boolean verified;
    private LocalDateTime createDateTime;

   

}




