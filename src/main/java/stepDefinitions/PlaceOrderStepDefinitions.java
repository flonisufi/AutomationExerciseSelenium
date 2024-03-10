package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.PlaceOrderPage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PlaceOrderStepDefinitions {

    PlaceOrderPage placeOrderPage = new PlaceOrderPage();

    @When("User proceed to Checkout and Add a comment")
    public void user_proceed_to_checkout_and_add_a_comment()
    {
        placeOrderPage.proccedToCheckOut();
        placeOrderPage.addComment();
    }

    @When("User Place Order and Give Bank Card Informations")
    public void user_place_order_and_give_bank_card_informations(io.cucumber.datatable.DataTable dataTable)
    {
        placeOrderPage.bankInfomations(dataTable);
    }

    @Then("Validate that Product is ordered")
    public void validate_that_product_is_ordered()
    {
        Assert.assertEquals(placeOrderPage.orderMessage(),"ORDER PLACED!");

    }
}
