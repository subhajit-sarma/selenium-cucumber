package com.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HandleWindowsPage extends BasePage {

    public HandleWindowsPage(WebDriver driver){
        super(driver);
    }

    public void navigateToWindowUrl(){
        navigateToUrl("https://www.hyrtutorials.com/p/window-handles-practice.html");
    }

    public void checkForNewTab(){
        click(By.id("newWindowBtn"));
        Set<String> totalWindowHandles =  this.driver.getWindowHandles();
        List<String> windows = new ArrayList<>(totalWindowHandles);
        Assertions.assertThat(windows.size()).isEqualTo(2);
        for(String s: windows){
            this.driver.switchTo().window(s);
            System.out.println("this is window handle: " +s);
            System.out.println("This is the title: " +wait.until(ExpectedConditions.not(ExpectedConditions.titleIs(""))));
            if(this.driver.getTitle().contains("Basic Controls")){
                break;
            }
        }
        wait.until(ExpectedConditions.titleContains("Basic Controls"));
        Assertions.assertThat(this.driver.getTitle()).isEqualTo("Basic Controls - H Y R Tutorials");
    }
    
}
