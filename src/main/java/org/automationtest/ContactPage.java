package org.automationtest;


import Utilities.WaitForElement;
import com.google.common.base.Verify;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage {
    private WebDriver driver;
    private WaitForElement wait;


    private By headerMessage = By.xpath("//*[@id='header-message']/div/strong");
    private By foreNameField = By.xpath("//input[@id='forename']");
    private By surnameField = By.id("surname");
    private By emailField = By.xpath("//input[@id='email']");
    private By telephoneNumberField = By.xpath("//input[@id='telephone']");
    private By messageTextField = By.xpath("//textarea[@id='message']");
    private By submitButton = By.xpath("//a[contains(text(),'Submit')]");
    private By fornameErrorMessage = By.xpath("//*[@id='forename-err']");
    private By emailErrorMessage = By.xpath("//*[@id='email-err']");
    private By messageTextErrorMessage = By.xpath("//*[@id='message-err']");
    private By successTextMessage = By.xpath("//div[@class='alert alert-success']");
    private By backButton = By.xpath("/html/body/div[2]/div/a");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public String verifyOnContactPage() {
        return driver.getCurrentUrl();
    }

    public String contactPageHeader() {
        wait = new WaitForElement(driver);
        wait.waitForElementExplicit(headerMessage);
        return driver.findElement(headerMessage).getText();
    }

    public void clickSubmitButton() {
        wait = new WaitForElement(driver);
        wait.waitForElementExplicit(submitButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement submit = driver.findElement(submitButton);
        js.executeScript("arguments[0].click()", submit);

    }

    public String readForenameErrorMessage() {
        wait = new WaitForElement(driver);
        wait.fluentWaitForElement(fornameErrorMessage);
        return driver.findElement(fornameErrorMessage).getText();

    }

    public String readEmailErrorMessage() {
        wait = new WaitForElement(driver);
        wait.fluentWaitForElement(emailErrorMessage);
        return driver.findElement(emailErrorMessage).getText();

    }

    public String readMessageErrorMessage() {
        wait = new WaitForElement(driver);
        wait.fluentWaitForElement(messageTextErrorMessage);
        return driver.findElement(messageTextErrorMessage).getText();

    }

    public void writeForenameTextField(String name) {
        wait = new WaitForElement(driver);
        wait.fluentWaitForElement(foreNameField);
        driver.findElement(foreNameField).sendKeys(name);
    }

    public void writeSurnameTextField(String surname) {
        wait = new WaitForElement(driver);
        wait.fluentWaitForElement(surnameField);
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void writeEmailTextField(String email) {
        wait = new WaitForElement(driver);
        wait.fluentWaitForElement(emailField);
        driver.findElement(emailField).sendKeys(email);
    }

    public void writeTelephoneTextField(String phone) {
        wait = new WaitForElement(driver);
        wait.fluentWaitForElement(telephoneNumberField);
        driver.findElement(foreNameField).sendKeys(phone);
    }

    public void writeMessageTextField(String message) {
        wait = new WaitForElement(driver);
        wait.fluentWaitForElement(messageTextField);
        driver.findElement(messageTextField).sendKeys(message);
    }

    public String readSuccessMessage() {
        wait = new WaitForElement(driver);
        wait.waitForElementExplicit(successTextMessage);
        return driver.findElement(successTextMessage).getText();

    }

    public void clickOnBackButton() {
        driver.findElement(backButton);
    }


}



