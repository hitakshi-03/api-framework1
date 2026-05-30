package com.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class config {

    private static Properties prop;
    static {
    
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/test/java/com/resources/config.properties");
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

public static String get(String key)

{
    return prop.getProperty(key);
}
}


