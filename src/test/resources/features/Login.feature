@Regression
Feature: Login Functionality for Phepha Application

  As a user
  I want to be able to log in using valid credentials
  So that I can access the Phepha dashboard

  Background:

    Given Login is displayed

  Scenario: Successful login with valid credentials
    When The user enters a valid email address
    And The user enters a valid password
    And The user clicks on the Login button
