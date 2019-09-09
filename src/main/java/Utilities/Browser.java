package Utilities;

public class Browser {

    /***
     * Opens a new URL on the current browser
     * @param url
     */
    public static void open(String url) {

        DriverFactory.getInstance().getDriver().get(url);
    }

    /***
     * Sets the browser type
     * @param driver
     */
    public static void setDriver(String driver) {
        DriverFactory.getInstance().setDriver(driver);
    }

    /***
     * Closes the current browser and removes the instance from the open browser map.
     */
    public static void closeDriver() {
        DriverFactory.getInstance().closeDriver();
    }
}
