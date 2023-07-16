package org.automationtest;

import Utilities.WaitForElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

    private WebDriver driver;
    private WaitForElement wait;

    private By cartPageMessage = By.xpath("/html/body/div[2]/div/p");
    private By cartTable = By.xpath("//form[@name='form']");
    private By rowOfItem = By.xpath("//form[@name='form']/table/tbody/tr");
    private By columnsInTheCart = By.xpath("/html/body/div[2]/div/form/table/tbody/tr[1]/td");
    private By firstProductInTheCart = By.xpath("//form[@name='form']/table/tbody/tr[1]/td");
    private By secondProductInTheCart = By.xpath("//form[@name='form']/table/tbody/tr[2]/td");
    private By thirdProductInTheCart = By.xpath("//form[@name='form']/table/tbody/tr[3]/td");


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String verifyOnCartPage() {
        return driver.getCurrentUrl();
    }

    public String verifyCartPageHeaderMessage() {
        wait = new WaitForElement(driver);
        wait.waitForElementExplicit(cartPageMessage);
        return driver.findElement(cartPageMessage).getText();
    }


    public List<WebElement> numberOfItemsInTheCart() {
        wait = new WaitForElement(driver);
        wait.waitForElementExplicit(rowOfItem);
        List<WebElement> listOfItemsBought = driver.findElements(rowOfItem);
        return listOfItemsBought;
    }

    public void priceOfItem() {
        int columnNumber = driver.findElements(columnsInTheCart).size();
        List<WebElement> itemsInCart = numberOfItemsInTheCart();
        for (int i = 1; i < itemsInCart.size(); i++) {
            driver.findElement(By.xpath("//form[@name='form']/table/tbody/tr[" + i + "]/td"));
            for (int j = 1; j < columnNumber; j++) {
                driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[" + i + "]/td[" + j + "]")).getText();

            }
        }


    }


}
