@Regression
Feature: Invalid Login Scenarios

  Background:
    Given Login is displayed

  Scenario: Invalid login with wrong email
    When user enters email "wrong@example.com" and password "Enk@y2020"
    And user clicks login
    Then user sees error message for incorrect credentials

  Scenario: Invalid login with wrong password
    When user enters email "brianmabunda00@gmail.com" and password "wrongpass"
    And user clicks login
    Then user sees error message for incorrect credentials

  Scenario: Empty email and password
    When user leaves email and password empty
    And user clicks login
    Then user sees browser validation message for empty email

  Scenario: Password visibility toggle
    When user enters password "Enk@y2020"
    And user toggles password visibility
    Then password is visible