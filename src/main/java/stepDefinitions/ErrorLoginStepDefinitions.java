package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ErrorLoginPage;
import pages.LoginPage;

public class ErrorLoginStepDefinitions {

    LoginPage loginPage = new LoginPage();
    ErrorLoginPage errorLoginPage = new ErrorLoginPage();

    @When("User enter email {string} and password {string}")
    public void user_is_loged_in_with_email_and_password(String email, String password) {
        if (email.equalsIgnoreCase("invalid")){
            email = "flonbaba@gmail.com";
            password = "1234";
        }
        else
        {
            email = "florryyii2@gmail.com";
            password = "Pakokosare1";
        }
        loginPage.userLogedIn(email,password);

    }


    @Then("An error message should be displayed")
    public void an_error_message_should_be_displayed()
    {
        Assert.assertEquals(errorLoginPage.errorMessage(),
                "Your email or password is incorrect!");

    }
}
