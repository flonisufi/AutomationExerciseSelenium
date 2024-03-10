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
       | Password  | Pakokosare1    |
       | Day       | 6              |
       | Month     | May            |
       | Year      | 2004           |
       | FirstName | Flon           |
       | LastName  | Isufi          |
       | Company   | Kin An Carta   |
       | Address1  | Qerqiz topulli |
       | Address2  | Gavran         |
       | Country   | Canada         |
       | State     | Kosova         |
       | City      | Gjilan         |
       | ZipCode   | 3000           |
       | MobilePh  | 049445517      |

       Then Validate that user is registered
