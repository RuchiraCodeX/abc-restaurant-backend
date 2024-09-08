package com.example.abc_restaurant.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

    private static final String UPLOAD_DIR = "/path/to/upload/directory/";

    public String uploadImage(MultipartFile imageFile) {
        try {
            String filename = imageFile.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR + filename);
            Files.write(filePath, imageFile.getBytes());
            return filePath.toString();  
        } catch (IOException e) {
            throw new RuntimeException("Image upload failed", e);
        }
    }
}

