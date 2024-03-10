@Test @Login
Feature: Login Functionality

  Background:
    Given User is on Automation Exercise Page
    When User is on SignUp/Login Page

    @ErrorLogin
  Scenario: Login User with incorrect credentials
      When User enter email "invalid" and password "invalid"
      Then An error message should be displayed

      @LoginLogOut
      Scenario: Login User and LogOut
        When User enter email "valid" and password "valid"
        When User is loged Out
        Then Validate that User is redirected to Automation Exercise Page

