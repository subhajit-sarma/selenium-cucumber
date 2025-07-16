package steps;

import com.pages.HandleAlertsPage;
import com.utilities.DriverManager;

import io.cucumber.java.en.Given;

public class AlertSteps {


    HandleAlertsPage alertPageObj = new HandleAlertsPage(DriverManager.getDriver());

    @Given("I navigate to alert page and click on ok")
    public void i_navigate_to_Aalert_page(){
        alertPageObj.navigateToAlertPage();
        alertPageObj.alerWithtOk();
        alertPageObj.alertWithOkAndCancel();
        alertPageObj.alertWithTextBox();
    }
}
