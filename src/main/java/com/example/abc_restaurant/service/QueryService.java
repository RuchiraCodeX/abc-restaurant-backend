package com.example.abc_restaurant.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.abc_restaurant.Models.Query;
import com.example.abc_restaurant.repository.QueryRepository;

@Service
public class QueryService {

    @Autowired
    private QueryRepository queryRepository;
    
    public List<Query> getAllQueries() {
        return queryRepository.findAll();
    }

   
    public Query submitQuery(Query query) {
        query.setCreatedAt(LocalDateTime.now());
        query.setUpdatedAt(LocalDateTime.now());
        query.setStatus("OPEN"); 
        return queryRepository.save(query);
    }

   
    public Optional<Query> getQueryById(String id) {
        return queryRepository.findById(id);
    }

  
    public List<Query> getQueriesByUserId(String userId) {
        return queryRepository.findByUserId(userId);
    }

   
    public Query updateQuery(Query query) {
        query.setUpdatedAt(LocalDateTime.now());
        return queryRepository.save(query);
    }

   
    public void deleteQuery(String id) {
        queryRepository.deleteById(id);
    }

    public Query respondToQuery(String userId, String responseText) {
        Optional<Query> optionalQuery = queryRepository.findById(userId);
        if (optionalQuery.isPresent()) {
            Query query = optionalQuery.get();
            query.setResponseText(responseText); 
            query.setStatus("RESPONDED"); 
            query.setUpdatedAt(LocalDateTime.now());
            return queryRepository.save(query);
        }
        return null;
    }
}

