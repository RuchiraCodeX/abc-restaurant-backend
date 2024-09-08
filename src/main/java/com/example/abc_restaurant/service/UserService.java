package com.example.abc_restaurant.service;


import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.abc_restaurant.Models.User;
import com.example.abc_restaurant.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) {
       
        if (userRepository.findByUsername(user.getUsername()).isPresent() || userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("User with this email or username already exists");
        }

        
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
       
        if (user.getRole() == null) {
            user.setRole("ROLE_CUSTOMER");  
        }
        user.setActive(true);
        user.setVerified(false);
        user.setCreateDateTime(LocalDateTime.now());

        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> getUserById(String userID) {
        return userRepository.findById(userID);
        }

        public Optional<User> authenticate(String username, String password) {
            Optional<User> user = userRepository.findByUsername(username);
            if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
                return user;
            } else {
                return Optional.empty();
            }
        }
}


   
    
   


