package UiTests;

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
