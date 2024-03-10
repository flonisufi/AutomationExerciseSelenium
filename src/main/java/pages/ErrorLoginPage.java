package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.io.IOException;

public class ErrorLoginPage {

    WebDriver driver = Driver.getData();

    public ErrorLoginPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "p[style='color: red;']")
    private WebElement errorMsg;


    public String errorMessage()
    {
        return errorMsg.getText();

    }
}
