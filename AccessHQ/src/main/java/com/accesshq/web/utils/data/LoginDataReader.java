package com.accesshq.web.utils.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LoginDataReader {

//    private Properties properties;
//    private final String propertyFilePath= System.getProperty("user.dir") + "\\src\\main\\java\\com\\practical\\web\\data\\LoginData.properties";
private Properties properties;
    private final String propertyFilePath= System.getProperty("user.dir") + "\\src\\main\\java\\com\\accesshq\\web\\data\\LoginData.properties";


    public LoginDataReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getUsername(){
        String Username = properties.getProperty("Username");
        if(Username!= null) return Username;
        else throw new RuntimeException("Username not specified in the Configuration.properties file.");
    }

    public String getPropertyValue(String propertyName){
        String PropertyValue = properties.getProperty(propertyName);
        if(PropertyValue!= null) return PropertyValue;
        else throw new RuntimeException("Username not specified in the Configuration.properties file.");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

}
