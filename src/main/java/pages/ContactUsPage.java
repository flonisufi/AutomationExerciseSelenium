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
import java.util.List;
import java.util.Map;

public class ContactUsPage {

    Faker faker = new Faker();

    public ContactUsPage() {
        PageFactory.initElements(Driver.getData(),this);
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

    public void informations(io.cucumber.datatable.DataTable dataTable)
    {
        List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);

        for (Map<String,String>row : data)
        {
            String elementName = row.get("Element");
            String information = row.get("Information");

            switch (elementName)
            {
                case "Name":
                    BrowserUtilities.waitForElementToAppear(nameField);
                    nameField.sendKeys(information);
                    break;
                case "Email":
                    emailField.sendKeys(information);
                    break;
                case "Subject":
                    subject.sendKeys(information);
                    break;
            }
        }
        message.sendKeys(faker.chuckNorris().fact());
        ((JavascriptExecutor) Driver.getData()).executeScript("arguments[0].scrollIntoView(true);",submit);
        submit.click();
        BrowserUtilities.alertHandle();

    }

    public String messageValidation()
    {
        BrowserUtilities.waitForElementToAppear(confirmMessage);
        return confirmMessage.getText();
    }
}
