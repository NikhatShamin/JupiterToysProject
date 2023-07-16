Feature:Jupiter Toys-Contact Page

  Background:
  Test case 1: Scenario--Contact Page - Validate Error Messages
  1. From the home page go to contact page
  2. Click submit button
  3. Verify error messages
  4. Populate mandatory fields
  5. Validate errors are gone

  Test case 2: Scenario--Contact Page - Validate Success Message
  1. From the home page go to contact page
  2. Populate mandatory fields
  3. Click submit button
  4. Validate successful submission message
  5.Note: Run this test 5 times to ensure 100% pass rate


  Scenario Outline: Contact Page - Validate Error Messages
    Given User is on home page
    When User clicks on Contact Page button
    And  Clicked on the Submit button
    Then Verify the error messages are displayed
    When User populates "<Forename>","<Email>","<Message>" the mandatory fields
    And Clicked on the Submit button
    Then Validate that error messages are not displayed
    Examples:
      | Forename  | Email            | Message   |
      | Register1 | Register@123.com | Hello!    |



  Scenario Outline: Contact Page - Validate Success Message
    Given User is on home page
    When User clicks on Contact Page button
    Then Verify contact page is open
    When User populates "<Forename>","<Email>","<Message>" the mandatory fields
    And Clicked on the Submit button
    Then Validate the successful Submission Message is displayed
    Examples:
      | Forename  | Email        | Message   |
      | Register1 | Register@123.com | Hello!    |
      | Register2 | Register@321.com | Hello Hi! |
      | Register3 | Register@111.com | Hello Hi Bye! |
      | Register4 | Register@222.com | Hello Hi Ola! |
      | Register5 | Register@333.com | Hello Hi Matane! |