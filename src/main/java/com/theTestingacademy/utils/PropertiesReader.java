package com.theTestingacademy.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    //fetch the data from the data.properties file

    public static String readKey(String key)  {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\rnish\\Development\\workspcae2024\\ATB8XSeleniumAdvanceFramework\\src\\test\\resources\\data.properties"));
            Properties p = new Properties();
            p.load(fileInputStream);
            return p.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
