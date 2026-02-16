@Regression
Feature: User Registration

  Background:
    Given Login is displayed

  Scenario: Verify create account link is clickable
    When the user clicks the create account link
    Then the registration form should be displayed

  Scenario: Register with empty name
    When the user clicks the create account link
    And the user fills all details except name
    And clicks the Sign-Up button
    Then a browser validation message should be displayed for the name field

    Scenario: Register with empty surname
    When the user clicks the create account link
    And the user leaves the surname field empty
    And clicks the Sign-Up button
    Then a browser validation message should be displayed for the surname field

  Scenario: Register with empty email
    When the user clicks the create account link
    And the user fills all details except email
    And clicks the Sign-Up button
    Then a browser validation message should be displayed for the email field

  Scenario: Register without selecting subscription
    When the user clicks the create account link
    And the user does not select any subscription
    And clicks the Sign-Up button
    Then a browser validation message should be displayed for the subscription field

  Scenario: Register with empty company name
    When the user clicks the create account link
    And the user fills all details except company name
    And clicks the Sign-Up button
    Then an OTP message should be displayed

  Scenario: Register with empty company registration number
    When the user clicks the create account link
    And the user fills all details except company registration number
    And clicks the Sign-Up button
    Then an OTP message should be displayed

  Scenario: Verify user receives OTP after register
    When the user clicks the create account link
    And the user enters valid details
    And clicks the Sign-Up button
    Then an OTP message should be displayed

  Scenario: Password mismatch
    When the user clicks the create account link
    And the user enters mismatching passwords
    And clicks the Sign-Up button
    Then an error message should be displayed

  Scenario: Toggle password visibility
    When the user clicks the create account link
    And the user toggles the password visibility
    Then the password should be visible

  Scenario: Register using existing email
    When the user clicks the create account link
    And the user enters an email that already exists
    And clicks the Sign-Up button
    Then an error message should be displayed

  Scenario: Register with both subscriptions selected
    When the user clicks the create account link
    And the user selects both subscriptions
    And the user enters valid details
    And clicks the Sign-Up button
    Then the user should see an OTP message after registration

  Scenario: Register with vehicle subscription only
    When the user clicks the create account link
    And the user selects vehicle subscription only
    And the user enters valid details
    And clicks the Sign-Up button
    Then the user should see an OTP message after registration

  Scenario: Successful user registration
    When the user clicks the create account link
    And the user enters valid details
    And clicks the Sign-Up button
    Then the user should see an OTP message after registration

  Scenario: Successful login after registration
    When the user enters a valid email and password
    And clicks the Sign-Up button
    Then the user should be logged in successfully
