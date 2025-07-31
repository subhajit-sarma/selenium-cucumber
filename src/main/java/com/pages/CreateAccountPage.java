package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.ConfigReader;
import com.utilities.RandomDataGenerator;

public class CreateAccountPage extends BasePage {
    private static By firstName = By.id("customer.firstName");
    private static By lastName = By.id("customer.lastName");
    private static By address = By.id("customer.address.street");
    private static By city = By.id("customer.address.city");
    private static By state = By.id("customer.address.state");
    private static By postalCode = By.id("customer.address.zipCode");
    private static By phone = By.id("customer.phoneNumber");
    private static By ssn = By.id("customer.ssn");
    private static By userName = By.id("customer.username");
    private static By password = By.id("customer.password");
    private static By confirmPassword = By.id("repeatedPassword");

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        navigateToUrl(ConfigReader.getInstance().getProperty("bankUrl"));
    }

    public void enterRegistrationDetails() {

        enterText(firstName, "testName");
        enterText(lastName, "testLastName");
        enterText(address, "test address");
        enterText(city, "melbourne");
        enterText(state, "vic");
        enterText(postalCode, "1234");
        enterText(phone, "456762323");
        enterText(ssn, "122323");
        enterText(userName, RandomDataGenerator.getRandomUserName(ConfigReader.getInstance().getProperty("bankUserName")));
        enterText(password, "Welcome123");
        enterText(confirmPassword, "Welcome123");
        click(By.xpath("//input[@value='Register']"));
    }
}
