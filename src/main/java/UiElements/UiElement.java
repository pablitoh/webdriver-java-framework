package UiElements;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.DriverFactory;


/***
 * Wrapper class for Elements in the UI. Extends this class for new elements. i.e: Custom Dropdowns
 * @author pabloconde
 */
public class UiElement {

    private By locator;
    private WebDriver driver;
    private WebDriverWait wait;

    /***
     *
     * @param locator Locator strategy to find the element
     */
    public UiElement(By locator)
    {
        this.locator = locator;
        this.driver = DriverFactory.getInstance().getDriver();
        this.wait =  new WebDriverWait(this.driver, 20);

    }

    /***
     * Gets an updated version of the element.
     * @return
     */
    protected WebElement getElement()
    {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

    /***
     * Waits and Click for the current element
     */
    public void click()
    {
        try
        {
            this.wait.until(ExpectedConditions.elementToBeClickable(locator));
            getElement().click();
        }
        catch(ElementNotVisibleException e)
        {
            moveToElement();
            getElement().click();
        }
    }

    /***
     * Executes javascript code to move the element into view.
     */
    private void moveToElement()
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement());
    }

    public String getText()
    {
        return getElement().getText();
    }


}
