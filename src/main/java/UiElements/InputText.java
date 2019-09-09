package UiElements;

import org.openqa.selenium.By;

/***
 * Input text field Ui Element
 */
public class InputText extends UiElement {

    /***
     *
     * @param locator Locator strategy to find the element
     */
    public InputText(By locator) {
        super(locator);
    }

    /***
     * Types string into field
     * @param text
     */
    public void type(String text)
    {
        getElement().sendKeys(text);
    }

}
