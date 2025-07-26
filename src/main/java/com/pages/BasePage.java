package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.*;
import org.openqa.selenium.io.FileHandler;


public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void jsClick(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
    }

    public void scrollIntoView(WebElement elemet){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", elemet);
    }

    public void navigateToUrl(String url){
        this.driver.get(url);
    }

    public void selectValueFromDropDown(WebElement element, String value){
        Select dropDownSelect = new Select(element);
        scrollIntoView(element);
        dropDownSelect.selectByValue(value);
    }

    public void takeScreenShot() {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = "screenshot"+ System.currentTimeMillis();
        try{
            FileHandler.copy(file, new File("src/test/resources/screenshots/"+fileName+".png"));
        }catch(Exception ex){
            ex.printStackTrace();
        }   
    }

    public void handleAlert(){
            
    }
    
}
