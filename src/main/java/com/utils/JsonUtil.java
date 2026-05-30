package com.utils;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtil {

    public static String readJson(String filePath) {
        try{
            return new String(Files.readAllBytes(Paths.get(filePath)));
            
        } catch (Exception e) {
           throw new RuntimeException("Failed to read JSON file: " + e.getMessage());
        }
    
}
}
