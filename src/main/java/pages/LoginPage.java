package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

import java.io.IOException;

public class LoginPage {



    public LoginPage() {
        PageFactory.initElements(Driver.getData(),this);
    }

    @FindBy(xpath = "//input[@placeholder='Email Address']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement loginBtn;
     @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logOut;

    public void userLogedIn(String email,String password)
    {

        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginBtn.click();
    }



    public void logOut()
    {
        logOut.click();
    }

    public String currentTitle()
    {
        return Driver.getData().getTitle();
    }


}
