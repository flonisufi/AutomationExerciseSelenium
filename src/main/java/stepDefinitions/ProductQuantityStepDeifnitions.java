package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ProductQuantityPage;

import java.io.IOException;

public class ProductQuantityStepDeifnitions {

    ProductQuantityPage productQuantityPage = new ProductQuantityPage();

    @When("User Add to Cart an Product")
    public void user_add_to_cart_an_product()
    {
        productQuantityPage.addProduct();

    }


    @Then("Verify Product Quantity in Cart Page")
    public void verify_product_quantity_in_cart_page()
    {
        Assert.assertEquals(productQuantityPage.getQuantity(),"4");

    }
}
