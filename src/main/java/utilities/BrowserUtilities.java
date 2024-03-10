package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserUtilities {

    static WebDriver driver = Driver.getData();

    static Select select;

    static Alert alert;

    public BrowserUtilities()
    {
        PageFactory.initElements(driver,this);
    }

    public static void selectHandles(WebElement ele,String value)
    {
        select = new Select(ele);
        select.selectByVisibleText(value);
    }

    public static void waitForElementToAppear(WebElement ele)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public static void alertHandle()
    {
        alert = driver.switchTo().alert();
        alert.accept();
    }


}
