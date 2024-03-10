package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.io.IOException;

public class CartBrandPage {

    WebDriver driver = Driver.getData();

    public CartBrandPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".brands-name")
    private WebElement cartBrands;

    public String getCartbrands()
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",cartBrands);
        return cartBrands.getText();
    }
}
