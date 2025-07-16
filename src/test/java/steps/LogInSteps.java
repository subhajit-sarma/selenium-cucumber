package steps;


import com.pages.LogInPage;
import com.utilities.DriverManager;

import io.cucumber.java.en.Given;

public class LogInSteps {

    LogInPage logInPageObj = new LogInPage(DriverManager.getDriver());

   @Given("I log in to the website")
    public void logInToWebsite(){
        System.out.println("came here");
        logInPageObj.navigateToLogInPage();
        logInPageObj.enterUserName();
        logInPageObj.enterPassword();
        logInPageObj.clickLogIn();
        logInPageObj.addProduct();
    }
}
