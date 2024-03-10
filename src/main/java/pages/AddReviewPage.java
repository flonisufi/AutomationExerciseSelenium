package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

import java.io.IOException;

public class AddReviewPage {

    WebDriver driver = Driver.getData();

    public AddReviewPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "a[href='/product_details/3']")
    private WebElement viewProduct;

    @FindBy(css = "#name")
    private WebElement nameField;

    @FindBy(css = "#email")
    private WebElement emailField;

    @FindBy(css = "textarea[name='review']")
    private WebElement comment;

    @FindBy(id = "button-review")
    private WebElement submit;

    @FindBy(css = "span[style='font-size: 20px;']")
    private WebElement confirmMessage;

    public void goToProduct()
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",viewProduct);
        viewProduct.click();
    }

    public void giveInformations(String name,String email)
    {
        BrowserUtilities.waitForElementToAppear(nameField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",nameField);
        nameField.sendKeys(name);
        emailField.sendKeys(email);

    }

    public void addReview()
    {
        comment.sendKeys("The product is to expensive!!");
    }

    public void submitReview()
    {
        submit.click();
    }

    public String reviewMessage()
    {
        BrowserUtilities.waitForElementToAppear(confirmMessage);
        return confirmMessage.getText();
    }
}
