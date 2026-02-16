@Regression
Feature: Dashboard Verification
  As a Phepha user
  I want to verify all dashboard components
  So that I can ensure the dashboard is working correctly

  Background:
    Given Login is displayed
    When the user logs in with valid credentials

  Scenario: Verify Dashboard Components
    And The user should be redirected to the dashboard page
    And click the hamburger menu
    And click the View All button
    And click the Chevron down icon
    And click See More
    And verify Total PPE Non-Compliance card is visible
    And click PPE sidebar and view Non-Compliance
    And verify total entries on PPE report
    And select year "2025" from Monthly Non-Compliance Overview dropdown
    And verify Monthly Non-Compliance Overview fullscreen works
    And select year "2025" from Monthly Non-Compliance Trend dropdown
    And verify Monthly Non-Compliance Trend fullscreen works
    And select year "2025" from Top Non-Compliance Categories dropdown
    And verify Top Non-Compliance Categories fullscreen works
    And select warehouse "pie-warehouse-1" and "pie-warehouse-2" form compare dropdown
    And verify Warehouse Comparison fullscreen works
