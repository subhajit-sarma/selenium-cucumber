package steps;

import com.pages.CreateAccountPage;
import com.utilities.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class BankSteps {
    

    private CreateAccountPage createBankPageObj = new CreateAccountPage(DriverManager.getDriver());

    @Given("I navigate to bank home page")
    public void i_navigate_to_bank_home_page(){
        createBankPageObj.navigateToHomePage();
    }

    @Then("I register for a new account")
    public void registerAccount(){
        createBankPageObj.enterRegistrationDetails();
    }
}
