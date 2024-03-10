package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.CartBrandPage;

import java.io.IOException;

public class CardBrandStepDefinitions {

    CartBrandPage cartBrandPage = new CartBrandPage();



    @Then("Verify Cart Brand Products")
    public void verify_cart_brand_products()
    {
        Assert.assertEquals(cartBrandPage.getCartbrands(),"(6)\n" +
                "POLO\n" +
                "(5)\n" +
                "H&M\n" +
                "(5)\n" +
                "MADAME\n" +
                "(3)\n" +
                "MAST & HARBOUR\n" +
                "(4)\n" +
                "BABYHUG\n" +
                "(3)\n" +
                "ALLEN SOLLY JUNIOR\n" +
                "(3)\n" +
                "KOOKIE KIDS\n" +
                "(5)\n" +
                "BIBA");

    }



    }
