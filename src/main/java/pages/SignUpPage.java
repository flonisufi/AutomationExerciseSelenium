package pages;

import com.github.javafaker.Faker;
import io.cucumber.java.it.Ma;
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

public class SignUpPage {


    public SignUpPage() {
        PageFactory.initElements(Driver.getData(),this);
    }

    @FindBy(css = ".fa-lock")
    private WebElement lock;

    @FindBy(css = "input[data-qa='signup-name']")
    private WebElement nameSign;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement emailSign;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement signBtn;

    @FindBy(css = "#id_gender1")
    private WebElement gender;

    @FindBy(css = "#password")
    private WebElement password;

    @FindBy(id = "days")
    private WebElement days;

    @FindBy(id = "months")
    private WebElement months;

    @FindBy(id = "years")
    private WebElement years;

    @FindBy(css = "#newsletter")
    private WebElement newsLetter;

    @FindBy(css = "#first_name")
    private WebElement firstName;

    @FindBy(css = "#last_name")
    private WebElement lastName;

    @FindBy(css = "#company")
    private WebElement company;

    @FindBy(css = "#address1")
    private WebElement address1;

    @FindBy(css = "#address2")
    private WebElement address2;

    @FindBy(css = "#country")
    private WebElement country;

    @FindBy(css = "#state")
    private WebElement state;

    @FindBy(css = "#city")
    private WebElement city;

    @FindBy(css = "#zipcode")
    private WebElement zipCode;

    @FindBy(css = "#mobile_number")
    private WebElement mobileNumber;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAcc;

    @FindBy(css = ".text-center")
    private WebElement signText;

    public void lockIn()
    {
        lock.click();
    }


    public void registerEmail(String name,String email)
    {

        nameSign.sendKeys(name);
        emailSign.sendKeys(email);
        signBtn.click();
    }

    public void signUpInformations(io.cucumber.datatable.DataTable dataTable)
    {
        List<Map<String,String>>data = dataTable.asMaps(String.class, String.class);

        gender.click();

        for (Map<String,String>row : data)
        {
            String elementName = row.get("Element");
            String information = row.get("Information");

            switch (elementName)
            {
                case "Password":
                    ((JavascriptExecutor) Driver.getData()).executeScript("arguments[0].scrollIntoView(true);",password);
                    password.sendKeys(information);
                    break;
                case "Day":
                    BrowserUtilities.selectHandles(days,information);
                    break;
                case "Month":
                    BrowserUtilities.selectHandles(months,information);
                    break;
                case "Year":
                    BrowserUtilities.selectHandles(years,information);
                    newsLetter.click();
                    break;
                case "FirstName":
                    firstName.sendKeys(information);
                    break;
                case "LastName":
                    lastName.sendKeys(information);
                    break;
                case "Company":
                    company.sendKeys(information);
                    break;
                case "Address1":
                    address1.sendKeys(information);
                    break;
                case "Address2":
                    address2.sendKeys(information);
                    break;
                case "Country":
                    ((JavascriptExecutor) Driver.getData()).executeScript("arguments[0].scrollIntoView(true);",country);
                    BrowserUtilities.selectHandles(country,information);
                    break;
                case "State":
                    state.sendKeys(information);
                    break;
                case "City":
                    city.sendKeys(information);
                    break;
                case "ZipCode":
                    zipCode.sendKeys(information);
                    break;
                case "MobilePh":
                    mobileNumber.sendKeys(information);
                    break;
            }
        }
        createAcc.click();
    }


    public String confirmText()
    {
        BrowserUtilities.waitForElementToAppear(signText);
        return signText.getText();
    }
}
