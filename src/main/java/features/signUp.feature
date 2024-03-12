@Test
Feature: Register User with existing email

   Background:
   Given User is on Automation Exercise Page
     When User is on SignUp/Login Page

   @SignUp
   Scenario: Give the information in Signup Landing Page
       When User register with name "valid" and existing email "valid"
       When User give all personal information
       | Element   | Information    |
       | Password  | ***********    |
       | Day       | 6              |
       | Month     | May            |
       | Year      | 2004           |
       | FirstName | *****          |
       | LastName  | *****          |
       | Company   | Kin An Carta   |
       | Address1  | ***********    |
       | Address2  | ***********    |
       | Country   | Canada         |
       | State     | ******         |
       | City      | ******         |
       | ZipCode   | *****          |
       | MobilePh  | 049445517      |

       Then Validate that user is registered
