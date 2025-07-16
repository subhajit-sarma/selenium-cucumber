package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.utilities.DriverManager;
import com.utilities.ReportUtilities;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
// import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BaseTest {
    

    public static  WebDriver driver;
    public static WebDriverWait wait;
    private static ExtentReports reports = ReportUtilities.getInstance();
    private static ExtentTest test;
    private static ExtentTest node;
    
        
        @Before
        public void beforScenario(Scenario scenario){
            test = reports.createTest(scenario.getName());
            node = test.createNode("Starting test");
    
        }
    
        @AfterStep
        public void afterStep(Scenario scenario){
            if(scenario.isFailed()){
                node.pass("fail");
            }else{
                node.pass("Pass");
            }
        }
    
        @After()
        public void afterScenario(){
            reports.flush();
        }
        
        @Before("@ui")
        public void setUp(){
            System.out.println("initializing driver");
            System.out.flush();
            // System.setProperty("webdriver.chrome.driver", "/users/ssarma/Downloads/chromedriver/chromedriver");
            
            // wait = new WebDriverWait(driver,30);
            // driver.manage().window().maximize();
            DriverManager.setDriver("chrome");
            DriverManager.getDriver().manage().window().maximize();

        }
    
        @After("@ui")
        public void tearDown(){
            DriverManager.closeDriver();
        }


        // public static WebDriver getDriver(){
        //     System.out.println("getting driver");
        //     return driver;
        // }
    
        public static ExtentTest getNode(){
            return node;
    }
}
