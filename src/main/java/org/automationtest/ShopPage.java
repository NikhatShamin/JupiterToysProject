package org.automationtest;


import Utilities.WaitForElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopPage {

    private WebDriver driver;
    private WaitForElement wait;
    private By stuffedFrogBuyButton = By.xpath("//*[@id='product-2']/div/p/a");
    private By fluffyBunnyBuyButton = By.xpath("//*[@id='product-4']/div/p/a");
    private By valentineBearBuyButton = By.xpath("//*[@id='product-7']/div/p/a");
    private By cartButton = By.xpath("//*[@id='nav-cart']/a");


    public ShopPage(WebDriver driver) {
        this.driver = driver;
    }

    public String verifyOnShopPage() {
        return driver.getCurrentUrl();
    }

    public void buyStuffedFrog(int itemNumber) {
        wait = new WaitForElement(driver);
        wait.waitForElementExplicit(stuffedFrogBuyButton);
        for (int i = itemNumber; i >= 1; i--) {
            driver.findElement(stuffedFrogBuyButton).click();
        }

    }

    public void buyFluffyBunny(int itemNumber) {
        wait = new WaitForElement(driver);
        wait.waitForElementExplicit(fluffyBunnyBuyButton);
        for (int i = itemNumber; i >= 1; i--) {
            driver.findElement(fluffyBunnyBuyButton).click();
        }

    }

    public void buyValentineBear(int itemNumber) {
        wait = new WaitForElement(driver);
        wait.waitForElementExplicit(valentineBearBuyButton);
        for (int i = itemNumber; i >= 1; i--) {
            driver.findElement(valentineBearBuyButton).click();
        }

    }

    public void navigateToCartPage(){
        wait=new WaitForElement(driver);
        wait.waitForElementExplicit(cartButton);
        driver.findElement(cartButton);

    }

    public CartPage clickIntoCartPage() {
        wait = new WaitForElement(driver);
        wait.waitForElementExplicit(cartButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement cart = driver.findElement(cartButton);
        js.executeScript("arguments[0].click()",cart);
        return new CartPage(driver);
    }




}
