package steps;

import com.pages.CreateAccountPage;
import com.pages.LogInBankAccountPage;
import com.utilities.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class BankSteps {
    

    private CreateAccountPage createBankPageObj = new CreateAccountPage(DriverManager.getDriver());
    private LogInBankAccountPage logInPageObj = new LogInBankAccountPage(DriverManager.getDriver());
    

    @Given("I navigate to bank home page")
    public void i_navigate_to_bank_home_page(){
        createBankPageObj.navigateToHomePage();
    }

    @Then("I register for a new account")
    public void registerAccount(){
        createBankPageObj.enterRegistrationDetails();
        String userName = CreateAccountPage.userNameValue;
        System.out.println("userName :"+userName);
        
    }

    @Given("I navigate to log in page and log in to existing account")
    public void i_navigate_to_login_page(){
        logInPageObj.loginToExistingAccount();
        
    }

    @Then("I open new account")
    public void i_open_new_loggedin_account(){
        logInPageObj.openNewLoggedInAccount();
    }
}
