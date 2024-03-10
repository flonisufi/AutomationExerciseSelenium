package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ContactUsPage;

import java.io.IOException;

public class ContactUsStepDefinitions {

    ContactUsPage contactUsPage = new ContactUsPage();




    @When("User click on Contact Us")
    public void user_get_in_to_contact_us()
    {
       contactUsPage.contactUs();
    }


    @When("User give the informations")
    public void user_give_the_informations()
    {
        contactUsPage.informations();

    }


    @Then("Validate that Contact us succesfully sent")
    public void validate_that_contact_us_succesfully_sent()
    {
        Assert.assertEquals(contactUsPage.messageValidation(),
                "Success! Your details have been submitted successfully.");
    }


}
