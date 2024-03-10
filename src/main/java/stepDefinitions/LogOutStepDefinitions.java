package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;

import java.io.IOException;

public class LogOutStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @When("User enter valid email {string} and password {string}")
    public void user_enter_valid_email_and_password(String email, String password)
    {
        if(email.equalsIgnoreCase("valid"))
        {
            email = "florryyii2@gmail.com";
            password = "Pakokosare1";
        }
        loginPage.userLogedIn(email,password);

    }
    @When("User is loged Out")
    public void user_is_loged_out()
    {
        loginPage.logOut();

    }
    @Then("Validate that User is redirected to Automation Exercise Page")
    public void validate_that_user_is_redirected_to_automation_exercise_page()
    {
        Assert.assertEquals(loginPage.currentTitle(),
                "Automation Exercise - Signup / Login");

    }


}
