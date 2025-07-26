package steps;

// import com.base.BaseTest;
import com.pages.HandleWindowsPage;
import com.utilities.DriverManager;

import io.cucumber.java.en.Given;

public class WindowHandleSteps {


    HandleWindowsPage windowsPage = new HandleWindowsPage(DriverManager.getDriver());

    @Given("I check windows")
    public void iCheckWindows(){
        System.out.println("current thread for check windows"+Thread.currentThread());
        BaseTest.getNode().pass("I check windows");
        windowsPage.navigateToWindowUrl();
        windowsPage.checkForNewTab();
    }
     
}