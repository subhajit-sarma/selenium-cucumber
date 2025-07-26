package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.logging.*;

import com.utilities.ConfigReader;

// import io.cucumber.java.cs.Ale;

public class HandleAlertsPage extends BasePage{

    private static final Logger logger = Logger.getLogger(HandleAlertsPage.class.getName());

    public HandleAlertsPage(WebDriver driver){
        super(driver);
    }

    public void navigateToAlertPage(){
        // navigateToUrl("https://demo.automationtesting.in/Aleclearrts.html");
        navigateToUrl(ConfigReader.getInstance().getProperty("test2Url"));
    }
    
    public void alerWithtOk(){
        click(By.xpath("//a[text()='Alert with OK ']"));
        click(By.xpath("//button[contains(text(), 'click the button to display an  alert box:')]"));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alertWithOk = driver.switchTo().alert();
        alertWithOk.accept();

    }

    public void alertWithOkAndCancel(){
        click(By.xpath("//a[text()='Alert with OK & Cancel ']"));
        click(By.xpath("//button[contains(text(), 'click the button to display a confirm box')]"));
        Alert alertWithOkAndCancel = driver.switchTo().alert();
        logger.info("logger test");
        alertWithOkAndCancel.accept();
    }

    public void alertWithTextBox(){
        click(By.xpath("//a[text()='Alert with Textbox ']"));
        click(By.xpath("//button[text()='click the button to demonstrate the prompt box ']"));
        try{
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alertWithTextBox = driver.switchTo().alert();
            alertWithTextBox.sendKeys("This is subhajit testing");
            alertWithTextBox.accept();
        }catch(Exception e){
            e.printStackTrace();
        }
       
    }
}
