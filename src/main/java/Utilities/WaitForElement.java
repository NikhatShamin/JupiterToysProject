package Utilities;

import com.google.common.base.Function;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static java.util.concurrent.TimeUnit.SECONDS;

public class WaitForElement {

    private WebDriver driver;

    public WaitForElement(WebDriver driver) {
        this.driver = driver;
    }

    public void fluentWaitForElement(By element) {

        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 2 seconds.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        try {
            WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {

                public WebElement apply(WebDriver driver) {
                    return driver.findElement(element);
                }

            });
        } catch (org.openqa.selenium.NoSuchElementException | TimeoutException | StaleElementReferenceException e) {
            e.printStackTrace();

        }
    }

    public void fluentWaitForListOfElement(List<WebElement> elementList) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        } catch (org.openqa.selenium.NoSuchElementException | TimeoutException | StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }


    public void waitForElementExplicit(By element, int seconds) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (org.openqa.selenium.NoSuchElementException | TimeoutException | StaleElementReferenceException e) {

            // Assert.fail("Element not visible on page" + element);
            e.printStackTrace();
        }

    }

    public void waitForElementExplicit(By element) {

        waitForElementExplicit(element,30);
    }


}
