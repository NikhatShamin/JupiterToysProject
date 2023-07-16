package org.automationtest.stepdefinitions;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.automationtest.ContactPage;
import org.automationtest.HomePage;
import org.automationtest.ShopPage;
import org.testng.asserts.SoftAssert;

public class ShopPageStepdefinition {

    private HomePage homePage = new HomePage(DriverFactory.getDriver());
    private ShopPage shopPage;
    private SoftAssert softAssert = new SoftAssert();


    @When("User clicks on Shop Page button")
    public void user_clicks_on_shop_page_button() {
        homePage.getURL();
        shopPage = homePage.clickIntoShopPage();

    }

    @Then("Verify Shop Page is Open")
    public void verify_shop_page_is_open() {
        String currentURl= shopPage.verifyOnShopPage();
        softAssert.assertTrue(currentURl.contains("https://jupiter.cloud.planittesting.com/#/shop"));
    }


    @When("User Buys {string},{string},{string}")
    public void user_buys(String stuffedFrog, String fluffyBunny, String valentineBear) {
        int numstuffedFrog = Integer.valueOf(stuffedFrog);
        int numfluffyBunny=Integer.valueOf(fluffyBunny);
        int numvalentineBear=Integer.valueOf(valentineBear);
        shopPage.buyStuffedFrog(numstuffedFrog);
        shopPage.buyFluffyBunny(numfluffyBunny);
        shopPage.buyValentineBear(numvalentineBear);


    }


}
