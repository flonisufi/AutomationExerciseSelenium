package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AddReviewPage;

import java.io.IOException;

public class AddReviewStepDefinitions {

    AddReviewPage addReviewPage = new AddReviewPage();


    @When("User get inside the Product")
    public void user_get_inside_the_product()
    {
        addReviewPage.goToProduct();
    }


    @When("User enter the name {string} and Email {string}")
    public void user_give_the_name_and_email(String name, String email)
    {
        addReviewPage.giveInformations(name,email);
    }


    @When("User Add Review and Submit")
    public void user_add_review_and_submit()
    {
        addReviewPage.addReview();
        addReviewPage.submitReview();
    }


    @Then("Validate The Add Review")
    public void validate_the_add_review()
    {
        Assert.assertEquals(addReviewPage.reviewMessage(),"Thank you for your review.");
    }
}
