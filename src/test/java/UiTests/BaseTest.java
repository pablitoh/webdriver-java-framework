package UiTests;

import Utilities.DriverFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Utilities.Browser;

/***
 * Base test page for Setup and TearDown
 */
public class BaseTest {


    @BeforeMethod
    public void setUp()
    {
        Browser.setDriver("chrome");
    }


    @AfterMethod
    public void tearDown()
    {
       Browser.closeDriver();
    }

}
