import org.testng.annotations.Test;
import utilities.DriverFactory;
import pages.HomePage;

public class TestContactUs extends BaseTest{

    /***
     * DEMO TEST. TODO:
     *
     * - Retry Analizer
     * - DataProvider
     */
    @Test
    public void first_test()
    {
        DriverFactory.getInstance().getDriver().get("http://automationpractice.com/index.php");
        HomePage home = new HomePage();
        home.click_contact_us();
    }

    @Test
    public void second_test()
    {
        DriverFactory.getInstance().getDriver().get("http://automationpractice.com/index.php");
        HomePage home = new HomePage();
        home.click_contact_us();
    }


}
