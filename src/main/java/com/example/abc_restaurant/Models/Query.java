package com.example.abc_restaurant.Models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "queries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Query {
    @Id
    private String id;
    private String userId;
    private String queryText;
    private String responseText; 
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

   

    public String getResponseText() {
        return responseText;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
