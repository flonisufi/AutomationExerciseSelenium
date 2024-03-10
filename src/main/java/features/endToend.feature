@Test
Feature: End to End

  Background:
    Given User is on Automation Exercise Page
    When User is on SignUp/Login Page
    When User enter valid email "florryyii2@gmail.com" and password "Pakokosare1"

    @ContactUs

    Scenario: Contact Us Form
      When User click on Contact Us
      When User give the informations
      | Element | Information         |
      | Name    | Flon                |
      | Email   | flonisufi@gmail.com |
      | Subject | Automation Testing  |


      Then Validate that Contact us succesfully sent

      @Subscription
      Scenario: Verify Subsciption in Cart Page
        When User click on Cart Page
        When User enter email "flonisufi@gmail.com" in Subscription
        Then Validate the Subscription succesfully sent

        @ProductQuantity
        Scenario: Verify Product Quantity in Cart
          When User Add to Cart an Product
          When User click on Cart Page
          Then Verify Product Quantity in Cart Page

          @PlaceOrder
          Scenario: Place Order: Register before Checkout
            When User Add to Cart an Product
            When User click on Cart Page
            When User proceed to Checkout and Add a comment
            When User Place Order and Give Bank Card Informations
            | Element    | Information |
            | NameCard   | FlonBaba    |
            | CardNumber | 1234        |
            | CVC        | 06          |
            | Exp        |  11         |
            | Year       |  2023       |

            Then Validate that Product is ordered


            @CartBrand
            Scenario: View & Card Brand Products
              Then Verify Cart Brand Products

              @AddReview
              Scenario: Add review on product
                When User get inside the Product
                When User enter the name "Flon" and Email "flonisufi@gmail.com"
                When User Add Review and Submit
                Then Validate The Add Review




