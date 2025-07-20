package com.base;

import java.net.MalformedURLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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

        @After()
        public void afterScenario(){
            reports.flush();
        }
    
        @AfterStep
        public void afterStep(Scenario scenario){
            if(scenario.isFailed()){
                node.pass("fail");
            }else{
                node.pass("Pass");
                final byte[] screenShot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenShot, "image/png", scenario.getName());
            }
        }
        
        @Before("@ui")
        public void setUp(){
            System.out.println("initializing driver");
            try {
                DriverManager.setDriver();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            DriverManager.getDriver().manage().window().maximize();

        }
    
        @After("@ui")
        public void tearDown(){
            DriverManager.closeDriver();
        }
    
        public static ExtentTest getNode(){
            return node;
    }
}
