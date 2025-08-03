package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInBankAccountPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(this.driver, 30);


    public LogInBankAccountPage(WebDriver driver){
        super(driver);
    }

   
    public void loginToExistingAccount(){
        navigateToUrl("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
        enterText(By.name("username"), "test_abc000");
        enterText(By.xpath("//input[@name='password']"), "Welcome123");
        click(By.xpath("//input[@value='Log In']"));

    }

    public void openNewLoggedInAccount(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(., 'Accounts Overview')]")));
        String accountNumber = this.driver.findElement(By.xpath("//a[contains(@href, 'activity.htm?id=')]")).getText();
        System.out.println(accountNumber);
        click(By.xpath("//a[contains(., 'Open New Account')]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(., 'Open New Account')]")));
        WebElement accountTypeDropDown = this.driver.findElement(By.id("type"));
        selectValueFromDropDown(accountTypeDropDown, "1");
        click(By.xpath("//input[(@type='button') and (@value='Open New Account')]"));
    }
    
}
