Feature: Forgot Password Functionality

  Background:

    Given Login is displayed

  Scenario: User opens Forgot Password page
    When user clicks forgot password link
    Then forgot password page should be displayed

  Scenario: User submits valid email for password reset
    When user clicks forgot password link
    And user enters forgot password email "mathabontuli2@gmail.com"
    And user submits forgot password request
    Then email sent confirmation should display

  Scenario: User resets password using reset link
    When user opens the reset password link
    And user enters new password "NewStrongPass123" and confirms "NewStrongPass123"
    And user submits new password
    Then password reset success message must display