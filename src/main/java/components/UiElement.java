package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverFactory;


/***
 * Wrapper class for Elements in the UI. Extends this class for new elements. i.e: Custom Dropdowns
 */
public class UiElement {

    private By locator;
    private WebDriver driver;
    private WebDriverWait wait;

    public UiElement(By locator)
    {
        this.locator = locator;
        this.driver = DriverFactory.getInstance().getDriver();
        this.wait =  new WebDriverWait(this.driver, 10);
    }


    private WebElement getElement()
    {
        return driver.findElement(locator);

    }

    /***
     * Waits and Click for the current element
     */
    public void click()
    {
        this.wait.until(ExpectedConditions.elementToBeClickable(locator));
        getElement().click();
    }


}
