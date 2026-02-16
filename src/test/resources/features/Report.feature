@Regression
Feature: Reports Module
  As a logged-in user
  I want to view and download PPE and Vehicle reports
  So that I can monitor compliance and vehicle information

  Background:
    Given Login is displayed
    When the user logs in with valid credentials

  # ---------------- PPE Reports ----------------
  Scenario: Verify user can view PPE reports and download them
    When the user clicks on the Reports menu
    Then the user should see PPE reports displayed
    And the user clicks next page on PPE reports
    And the user clicks previous page on PPE reports
    And the user sorts PPE reports by province and timestamp
    And the user downloads the PPE report

  # ---------------- Vehicle Reports ----------------
  Scenario: Verify user can view Vehicle reports and download them
    When the user navigates to Vehicle Reports
    Then the user should see Vehicle reports displayed
    And the user downloads the vehicle report