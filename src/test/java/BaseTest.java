import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.DriverFactory;

public class BaseTest {

    @BeforeMethod
    public void setUp()
    {
        DriverFactory.getInstance().setDriver("chrome");
    }


    @AfterMethod
    public void tearDown()
    {
        DriverFactory.getInstance().getDriver().close();
    }
}
