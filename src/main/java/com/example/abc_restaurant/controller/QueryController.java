package com.example.abc_restaurant.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.abc_restaurant.Models.Query;
import com.example.abc_restaurant.service.QueryService;

@RestController
@RequestMapping("/queries")
public class QueryController {

    @Autowired
    private QueryService queryService;

    @GetMapping("/all")
    public List<Query> getAllQueries() {
        return queryService.getAllQueries();
    }

   
    @PostMapping("/add")
    public ResponseEntity<Query> submitQuery(@RequestBody Query query) {
        Query createdQuery = queryService.submitQuery(query);
        return ResponseEntity.ok(createdQuery);
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<Query> getQueryById(@PathVariable String id) {
        return queryService.getQueryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/respond/{id}")
    public ResponseEntity<Query> respondToQuery(@PathVariable String id, @RequestBody String responseText) {
        Query updatedQuery = queryService.respondToQuery(id, responseText);
        return updatedQuery != null ? ResponseEntity.ok(updatedQuery) : ResponseEntity.notFound().build();
    }

   
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Query>> getQueriesByUserId(@PathVariable String userId) {
        List<Query> queries = queryService.getQueriesByUserId(userId);
        return ResponseEntity.ok(queries);
    }

    
    @PutMapping("/update/{id}")
    public ResponseEntity<Query> updateQuery(@PathVariable String id, @RequestBody Query query) {
        query.setId(id);
        Query updatedQuery = queryService.updateQuery(query);
        return ResponseEntity.ok(updatedQuery);
    }

   
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteQuery(@PathVariable String id) {
        queryService.deleteQuery(id);
        return ResponseEntity.noContent().build();
    }
}
