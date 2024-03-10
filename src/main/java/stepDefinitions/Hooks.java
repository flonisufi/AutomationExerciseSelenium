package stepDefinitions;

import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import utilities.Driver;

import java.io.File;
import java.io.IOException;

public class Hooks {

    static WebDriver driver = Driver.getData();

    public Hooks()
    {
        PageFactory.initElements(driver,this);
    }

    @Before
    public void setUp()
    {
        driver.get("https://automationexercise.com/");
    }

    @AfterAll
    public static void before_or_after_all()
    {
        driver.quit();
    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {
        if (scenario.isFailed())
        {
           File sourcPath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           byte[] fileContent = FileUtils.readFileToByteArray(sourcPath);
           scenario.attach(fileContent,"image/png","image");

        }

    }
}
