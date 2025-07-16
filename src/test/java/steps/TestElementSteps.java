package steps;


import com.pages.TestElementsPage;
import com.utilities.DriverManager;

import io.cucumber.java.en.Given;


public class TestElementSteps {
    
    TestElementsPage testElementsPage = new TestElementsPage(DriverManager.getDriver());

    @Given("I test the website")
    public void test_website() throws InterruptedException{
        System.out.println("Current thread for test website"+Thread.currentThread());
        testElementsPage.navigateToTestUrl();
        testElementsPage.clickOnDropDown();
        // testElementsPage.changeTab();
        testElementsPage.checkbox();
    }
}
