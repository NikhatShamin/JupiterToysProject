package org.automationtest.stepdefinitions;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.automationtest.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePageStepdefinition {

    //private WebDriver driver;
    private HomePage homePage = new HomePage(DriverFactory.getDriver());

    @Given("User is on home page")
    public void user_is_on_home_page() {
        homePage.getURL();
        String pageTitle = homePage.getHomePageTitle();
        Assert.assertTrue(pageTitle.contains("Jupiter Toys"));
    }

    @Then("Header message should be displayed")
    public void header_message_should_be_displayed() {
        String headerMessage=homePage.homePageHeaderMessage();
        Assert.assertTrue(headerMessage.contains("Jupiter Toys"));
    }


}
