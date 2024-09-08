package com.example.abc_restaurant.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.abc_restaurant.Models.Query;

public interface QueryRepository extends MongoRepository<Query, String> {
    List<Query> findByUserId(String userId);
}
