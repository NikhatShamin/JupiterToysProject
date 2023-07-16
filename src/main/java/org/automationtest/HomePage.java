package org.automationtest;

import Utilities.ConfigReader;
import Utilities.WaitForElement;
import driverFactory.DriverFactory;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class HomePage {

    private WebDriver driver;
    private Properties properties;
    private ConfigReader configReader;

    private WaitForElement wait;

    private By homepageHeader = By.xpath("/html/body/div[2]/div/div/div[2]/div/p[1]");
    private By shopPageButton = By.xpath("//*[@id='nav-shop']/a");
    private By contactPageButton = By.xpath("//*[@id='nav-contact']/a");
    private By cartPageButton = By.xpath("//*[@id='nav-cart']/a");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void getURL() {
        configReader = new ConfigReader();
        properties = configReader.readFromPropertiesFile();
        String projectURL = properties.getProperty("Url");
        DriverFactory.getDriver().get(projectURL);

    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public String homePageHeaderMessage() {

        wait = new WaitForElement(driver);
        wait.fluentWaitForElement(homepageHeader);
        return driver.findElement(homepageHeader).getText();
    }

    public ContactPage clickIntoContactPage() {
        wait = new WaitForElement(driver);
        wait.waitForElementExplicit(contactPageButton);
        driver.findElement(contactPageButton).click();
        return new ContactPage(driver);
    }

    public ShopPage clickIntoShopPage() {
        wait = new WaitForElement(driver);
        wait.fluentWaitForElement(shopPageButton);
        driver.findElement(shopPageButton).click();
        return new ShopPage(driver);
    }

    public CartPage clickIntoCartPage() {
        wait = new WaitForElement(driver);
        wait.fluentWaitForElement(cartPageButton);
        driver.findElement(cartPageButton).click();
        return new CartPage(driver);
    }



}
