package stepDefinitions;

import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.io.File;
import java.io.IOException;


public class Hooks {
    public Hooks()
    {
        PageFactory.initElements(Driver.getData(),this);
    }

    @Before
    public void setUp()
    {
        Driver.getData().get(ConfigurationReader.getProperty("url"));

    }

    @AfterAll
    public static void after_all()
    {
        System.out.println("You are the best QA Enginer");
        Driver.getData().quit();
    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {
        if (scenario.isFailed())
        {
           File sourcPath = ((TakesScreenshot)Driver.getData()).getScreenshotAs(OutputType.FILE);
           byte[] fileContent = FileUtils.readFileToByteArray(sourcPath);
           scenario.attach(fileContent,"image/png","image");

        }

    }
}
