package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;


/***
 * Singleton Class for handling browser. Using ThreadLocal for parallel execution.
 *
 */
public class DriverFactory {


    private static DriverFactory instance = null;
    HashMap<String,WebDriver> driver_map  = new HashMap<String,WebDriver>();


    private DriverFactory()
    {
    }

    public static DriverFactory getInstance()
    {
        if(instance==null) {
            instance = new DriverFactory();
        }
            return instance;
    }

    /***
     * Sets the driver the proper instance.
     *
     * TODO:
     * - Enum for browser type
     * - Get driver type from cfg style ( default ) , CLI for parametrization.
     *
     * @param browser
     */
    public final void setDriver(String browser)
    {
        if(browser=="chrome")
        {
            System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver");
            driver_map.put(Thread.currentThread().toString(),new ChromeDriver());
        }
    }

    public WebDriver getDriver()
    {
        return driver_map.get(Thread.currentThread().toString());
    }


}
