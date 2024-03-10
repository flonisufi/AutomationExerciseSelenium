package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.SubscriptionPage;

import java.io.IOException;

public class SubscriptionStepDefinitions {

    SubscriptionPage subscriptionPage = new SubscriptionPage();


    @When("User click on Cart Page")
    public void user_get_in_to_cart_page()
    {
        subscriptionPage.cartPage();
    }


    @When("User enter email {string} in Subscription")
    public void user_give_email_in_subscription(String email)
    {
        subscriptionPage.setSubEmail(email);

    }


    @Then("Validate the Subscription succesfully sent")
    public void validate_the_subscription_succesfully_sent()
    {
        Assert.assertEquals(subscriptionPage.subMessage(),
                "You have been successfully subscribed!");

    }
}
