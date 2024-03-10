package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

import java.io.IOException;

public class ProductQuantityPage {



    public ProductQuantityPage() {
        PageFactory.initElements(Driver.getData(),this);
    }

    @FindBy(xpath = "//a[@data-product-id='3']")
    private WebElement addToCart;

    @FindBy(css = "button[data-dismiss='modal']")
    private WebElement continueShopp;

    @FindBy(css = "a[href='/view_cart']")
    private WebElement cart;

    @FindBy(css = ".disabled")
    private WebElement quantity;


    public void addProduct()
    {
        BrowserUtilities.waitForElementToAppear(addToCart);
        ((JavascriptExecutor) Driver.getData()).executeScript("arguments[0].scrollIntoView(true);",addToCart);
        addToCart.click();
        BrowserUtilities.waitForElementToAppear(continueShopp);
        continueShopp.click();
        ((JavascriptExecutor) Driver.getData()).executeScript("arguments[0].scrollIntoView(true);",cart);

    }

    public String getQuantity()
    {
        return quantity.getText();
    }




}
