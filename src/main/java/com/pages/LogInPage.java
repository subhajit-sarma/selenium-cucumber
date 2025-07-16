package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
    

    public WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLogInPage(){
        this.driver.get("https://www.saucedemo.com/");
    }

    public void enterUserName(){
        this.driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    public void enterPassword(){
        this.driver.findElement(By.id("password")).sendKeys("secret_sauce");;
    }

    public void clickLogIn(){
        this.driver.findElement(By.id("login-button")).click();
    }

    public void addProduct(){
        this.driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
    }
}
