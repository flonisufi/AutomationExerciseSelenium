package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.io.IOException;

public class CartBrandPage {



    public CartBrandPage()
    {
        PageFactory.initElements(Driver.getData(),this);
    }

    @FindBy(css = ".brands-name")
    private WebElement cartBrands;

    public String getCartbrands()
    {
        ((JavascriptExecutor) Driver.getData()).executeScript("arguments[0].scrollIntoView(true);",cartBrands);
        return cartBrands.getText();
    }
}
