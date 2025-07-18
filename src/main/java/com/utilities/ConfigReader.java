package com.utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {


    public static Properties prop;
    private static ConfigReader config;

    private ConfigReader(){
        try{
            prop = new Properties();
            InputStream input = new FileInputStream("src/test/resources/config/global.properties");
            prop.load(input);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


    public static ConfigReader getInstance() {
        if (config == null) {
            synchronized (ConfigReader.class) {
                if (config == null) {
                    config = new ConfigReader();
                }
            }
        }
        return config;
    }


    public String getProperty(String str){
        return prop.getProperty(str);
    }

}