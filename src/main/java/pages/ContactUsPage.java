package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

import java.io.IOException;

public class ContactUsPage {

    WebDriver driver = Driver.getData();
    Faker faker = new Faker();

    public ContactUsPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "a[href='/contact_us']")
    private WebElement contactUsBtn;

    @FindBy(css = "input[name='name']")
    private WebElement nameField;

    @FindBy(css = "input[name='email']")
    private WebElement emailField;

    @FindBy(css = "input[name='subject']")
    private WebElement subject;

    @FindBy(css = "#message")
    private WebElement message;

    @FindBy(css = "input[name='submit']")
    private WebElement submit;

    @FindBy(css = ".alert-success")
    private WebElement confirmMessage;


    public void contactUs()
    {
        contactUsBtn.click();
    }

    public void informations()
    {
        nameField.sendKeys(faker.name().fullName());
        emailField.sendKeys("flonbaba@gmail.com");
        subject.sendKeys("Client");
        message.sendKeys(faker.chuckNorris().fact());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",submit);
        submit.click();
        BrowserUtilities.alertHandle();
    }

    public String messageValidation()
    {
        return confirmMessage.getText();
    }
}
