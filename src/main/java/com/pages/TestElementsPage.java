package com.pages;

import java.util.concurrent.TimeUnit;

// import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// import java.util.logging.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.base.BasePage;

public class TestElementsPage extends BasePage{

    // private static final Logger logger = Logger.getLogger(TestElementsPage.class.getName());

    public TestElementsPage(WebDriver driver){
        super(driver);
    }

    public void navigateToTestUrl(){
        navigateToUrl("https://ultimateqa.com/simple-html-elements-for-automation/");
    }

    public void clickOnDropDown(){
        WebElement dropdown = driver.findElement(By.xpath("//div[contains(text(), 'Select an option and validate that it is selected')]/select"));
        selectValueFromDropDown(dropdown, "saab");
    }

    public void checkbox(){
        WebElement checkBoxElement = driver.findElement(By.xpath("//input[@value='Bike']"));
        scrollIntoView(checkBoxElement);
        checkBoxElement.click();
        takeScreenShot();
    }

    public void changeTab() throws InterruptedException{
        WebElement tab2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(@class,'tab_1')]/a")));
        System.out.println(driver.findElements(By.xpath("//li[contains(@class,'tab_1')]/a")).size());
        
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", tab2);
        System.out.println("wait started");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS );
        System.out.println("wait finsihed");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", tab2);
        // tab2.click();
        // System.out.println(tab2.isEnabled());
        // Actions tabActions = new Actions(driver);
        // tabActions.moveToElement(tab2).pause(500).click().build().perform();
    }
}
