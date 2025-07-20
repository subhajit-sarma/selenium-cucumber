package com.utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void setDriver() throws MalformedURLException{
        WebDriver driverInstance;
        String browser;
        String browserName = ConfigReader.getInstance().getProperty("browser");
        if(System.getProperty("browser")!=null){
            browser = System.getProperty("browser");
        }else {
            browser = browserName;
        }
        if(browser.equals("safari")){
            driverInstance = new SafariDriver();
        }else{
            System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
            // DesiredCapabilities capabilities = new DesiredCapabilities();
            // capabilities.setBrowserName(browserName);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless");
            options.addArguments("--remote-debugging-port=9222"); // Avoid DevToolsActivePort error
            options.addArguments("--disable-gpu");
            driverInstance = new ChromeDriver(options);
            // driverInstance = new RemoteWebDriver(new URL("http://localhost:4444/"), capabilities);

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
