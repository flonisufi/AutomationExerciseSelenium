package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

import java.io.IOException;

public class SubscriptionPage {

    WebDriver driver = Driver.getData();

    public SubscriptionPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@href='/view_cart']")
    private WebElement cart;

    @FindBy(id = "susbscribe_email")
    private WebElement subEmail;

    @FindBy(css = "#subscribe")
    private WebElement submit;

    @FindBy(css = ".alert-success")
    private WebElement confirmMessage;

    public void cartPage()
    {
        cart.click();
    }


    public void setSubEmail(String email)
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",subEmail);
        subEmail.sendKeys(email);
        submit.click();
    }

    public String subMessage()
    {
        BrowserUtilities.waitForElementToAppear(confirmMessage);
        return confirmMessage.getText();
    }
}
