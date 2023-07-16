package org.automationtest.stepdefinitions;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.automationtest.CartPage;
import org.automationtest.HomePage;
import org.automationtest.ShopPage;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class CartPageStepdefinition {

    private WebDriver driver;
    private HomePage homePage = new HomePage(DriverFactory.getDriver());
    private ShopPage shopPage;
    private CartPage cartPage;
    private SoftAssert softAssert = new SoftAssert();

    @When("User goes to Cart page")
    public void user_goes_to_cart_page() {
        shopPage = new ShopPage(driver);
        cartPage = shopPage.clickIntoCartPage();
    }

    @Then("Verify Cart Page is open")
    public void verify_cart_page_is_open() {
        String currentURL=cartPage.verifyOnCartPage();
        softAssert.assertTrue(currentURL.contains("https://jupiter.cloud.planittesting.com/#/cart"));
        String headerMessage=cartPage.verifyCartPageHeaderMessage();
        softAssert.assertTrue(headerMessage.contains("There are 10 items in your cart, you can Checkout or carry on Shopping."));
    }

    @Then("Verify subtotal of each product {string},{string},{string}")
    public void verify_subtotal_of_each_product(String product1Price, String product2Price, String product3Price) {

    }

    @Then("Verify the price of each product {string},{string},{string}")
    public void verify_the_price_of_each_product(String product1Price, String product2Price, String product3Price) {

    }



    @Then("Verify the total sum of Shopping {string},{string},{string} {string},{string},{string}")
    public void verify_the_total_sum_of_shopping(String product1, String product2, String product3, String product1Price, String product2Price, String product3Price) {

    }

}
