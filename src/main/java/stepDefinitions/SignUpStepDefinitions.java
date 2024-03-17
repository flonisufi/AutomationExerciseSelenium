package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.SignUpPage;
import utilities.Driver;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SignUpStepDefinitions  {

    Faker faker = new Faker();


    SignUpPage signUpPage = new SignUpPage();

    @Given("User is on Automation Exercise Page")
    public void user_is_on_register_page()
    {


    }

    @When("User is on SignUp\\/Login Page")
    public void user_is_on_signup_loginpage()
    {
        signUpPage.lockIn();

    }

    @When("User register with name {string} and existing email {string}")
    public void user_get_in_to_signup_page_and_register_with_name_and_existing_email(String name, String email)
    {
        if (name.equalsIgnoreCase("valid"))
        {
            name = faker.name().fullName();
            email = faker.internet().emailAddress();
        }
        signUpPage.registerEmail(name,email);

    }

    @When("User give all personal information")
    public void user_give_all_personal_information(io.cucumber.datatable.DataTable dataTable)
    {
        signUpPage.signUpInformations(dataTable);

    }


    @Then("Validate that user is registered")
    public void validate_that_user_is_registered()
    {
        Assert.assertEquals(signUpPage.confirmText(),"ACCOUNT CREATED!");

    }


}
