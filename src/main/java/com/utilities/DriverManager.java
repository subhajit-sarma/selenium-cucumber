package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void setDriver(String browserName){
        WebDriver driverInstance;
        if(browserName.equals("safari")){
            driverInstance = new SafariDriver();
        }else{
//            System.setProperty("webdriver.chrome.driver","driver/chromedriver");
             ChromeOptions options = new ChromeOptions();
             options.addArguments("--headless");
            driverInstance = new ChromeDriver(options);
        }
            
        driver.set(driverInstance);
    }
    
    public static void closeDriver(){
        if(driver.get()!= null){
            driver.get().quit();
            driver.remove();
        }
    }
}
