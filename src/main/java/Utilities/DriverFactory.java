package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.ConcurrentHashMap;


/***
 * Singleton Class for handling browser.
 * @author pabloconde
 */
public class DriverFactory {


    private static DriverFactory instance = null;
    ConcurrentHashMap<String,WebDriver> driver_map  = new ConcurrentHashMap<String,WebDriver>();


    private DriverFactory()
    {
    }

    /***
     * Get instance of the Driver Factory Singleton
     * @return
     */
    public synchronized static DriverFactory getInstance()
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

    /***
     *
     * @return The current driver for this thread.
     */
    public WebDriver getDriver()
    {
        return driver_map.get(Thread.currentThread().toString());
    }

    /***
     * Closes current driver and removes the instance of the concurrent hashmap
     */
    public void closeDriver()
    {
        getDriver().close();
        driver_map.remove(Thread.currentThread().toString());
    }


}
