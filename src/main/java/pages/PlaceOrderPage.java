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

public class PlaceOrderPage {

    Faker faker = new Faker();

    public PlaceOrderPage()
    {
        PageFactory.initElements(Driver.getData(),this);
    }


    @FindBy(css = ".check_out")
    private WebElement checkout;

    @FindBy(css = "textarea[name='message']")
    private WebElement comment;

    @FindBy(name = "name_on_card")
    private WebElement nameOnCard;

    @FindBy(name = "card_number")
    private WebElement cardNumber;

    @FindBy(name = "cvc")
    private WebElement cardCvc;

    @FindBy(name = "expiry_month")
    private WebElement expMonth;

    @FindBy(name = "expiry_year")
    private WebElement expYear;

    @FindBy(id = "submit")
    private WebElement submit;

    @FindBy(xpath = "//b[text()='Order Placed!']")
    private WebElement confirmMessage;

    public void proccedToCheckOut()
    {
        checkout.click();
    }

    public void addComment()
    {
        ((JavascriptExecutor) Driver.getData()).executeScript("arguments[0].scrollIntoView(true);",comment);
        comment.sendKeys("The Product is good Quality!");

    }



    public void bankInfomations(io.cucumber.datatable.DataTable dataTable)
    {
        List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);

        checkout.click();

        for (Map<String,String>row : data)
        {
            String elementName = row.get("Element");
            String information = row.get("Information");

            switch (elementName)
            {
                case "NameCard":
                    BrowserUtilities.waitForElementToAppear(nameOnCard);
                    nameOnCard.sendKeys(information);
                    break;
                case "CardNumber":
                    cardNumber.sendKeys(faker.business().creditCardNumber());
                    break;
                case "CVC":
                    cardCvc.sendKeys(faker.business().creditCardExpiry());
                    break;
                case "Exp":
                    expMonth.sendKeys(faker.business().creditCardExpiry());
                    break;
                case "Year":
                    expYear.sendKeys(faker.business().creditCardExpiry());
                    break;
            }
        }
        submit.click();
    }

    public String orderMessage()
    {
        BrowserUtilities.waitForElementToAppear(confirmMessage);
        return confirmMessage.getText();
    }



}
