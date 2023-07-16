package org.automationtest.stepdefinitions;

import com.google.common.base.Verify;
import driverFactory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.automationtest.ContactPage;
import org.automationtest.HomePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ContactPageStepdefinition {

    private HomePage homePage = new HomePage(DriverFactory.getDriver());
    private ContactPage contactPage;
    private SoftAssert softAssert = new SoftAssert();


    @When("User clicks on Contact Page button")
    public void user_clicks_on_contact_page_button() {
        homePage.getURL();
        contactPage = homePage.clickIntoContactPage();
        String OnContactPage = contactPage.verifyOnContactPage();
        softAssert.assertTrue(OnContactPage.contains("https://jupiter.cloud.planittesting.com/#/contact"));
    }

    @Then("Verify contact page is open")
    public void verify_contact_page_is_open() {
         String headerContactPage= contactPage.contactPageHeader();
         softAssert.assertTrue(headerContactPage.contains("We welcome your feedback"));
    }

    @When("Clicked on the Submit button")
    public void clicked_on_the_submit_button() {
        contactPage.clickSubmitButton();

    }

    @Then("Verify the error messages are displayed")
    public void verify_the_error_messages_are_displayed() {
        String forenameErrorMessage = contactPage.readForenameErrorMessage();
        String emailErrorMessage = contactPage.readEmailErrorMessage();
        String messageErrorMessage = contactPage.readMessageErrorMessage();
        softAssert.assertTrue(forenameErrorMessage.contains("Forename is required"));
        softAssert.assertTrue(emailErrorMessage.contains("Email is required"));
        softAssert.assertTrue(messageErrorMessage.contains("Message is required"));

    }

    @When("User populates {string},{string},{string} the mandatory fields")
    public void user_populates_the_mandatory_fields(String name, String email, String message) {
        contactPage.writeForenameTextField(name);
        contactPage.writeEmailTextField(email);
        contactPage.writeMessageTextField(message);
    }

    @Then("Validate that error messages are not displayed")
    public void validate_that_error_messages_are_not_displayed() {
        String successMessage = contactPage.readSuccessMessage();
        Assert.assertTrue(successMessage.contains(", we appreciate your feedback."));
    }

    @Then("Validate the successful Submission Message is displayed")
    public void validate_the_successful_submission_message_is_displayed() {
        String successMessage = contactPage.readSuccessMessage();
        Assert.assertTrue(successMessage.contains(", we appreciate your feedback."));
    }


}
