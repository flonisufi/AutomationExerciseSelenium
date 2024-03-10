package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/main/java/features"
,glue = "stepDefinitions",monochrome = true,tags = "@SignUp",publish = true,
        plugin = {"html:target/cucumber.html",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "rerun:target/failed_scenarios.txt"})

public class TestNGRunner extends AbstractTestNGCucumberTests {

}
