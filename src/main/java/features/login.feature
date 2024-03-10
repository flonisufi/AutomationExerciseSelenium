Feature: Login Functionality

  Background:
    Given User is on Automation Exercise Page
    When User is on SignUp/Login Page

    @ErrorLogin

  Scenario: Login User with incorrect credentials
      When User enter invalid email "flonbaba@gmail.com" and password "1234"
      Then An error message should be displayed

      @LoginLogOut
      Scenario: Login User and LogOut
        When User enter valid email "florryyii2@gmail.com" and password "Pakokosare1"
        When User is loged Out
        Then Validate that User is redirected to Automation Exercise Page

