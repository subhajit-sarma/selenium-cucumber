package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
            System.out.println(System.getProperty("user.dir"));
            System.setProperty("webdriver.chrome.driver","/Users/ssarma/Documents/Personal/Jobs/selenium-cucumber/driver/chromedriver");
            // ChromeOptions options = new ChromeOptions();
            // options.addArguments("headless=false");
            driverInstance = new ChromeDriver();
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
