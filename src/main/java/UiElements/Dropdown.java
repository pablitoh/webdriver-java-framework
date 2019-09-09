package UiElements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

/***
 * Wrapper Class for SELECT selenium element.
 * TODO: Expand class with all select methods
 * @author pabloconde
 */
public class Dropdown extends UiElement {

    private Select dropdown;

    public Dropdown(By locator)
    {
        super(locator);
        this.dropdown = new Select(super.getElement());
    }

    public void selectByText(String option)
    {
        dropdown.selectByVisibleText(option);
    }

    public void selectByIndex(int index)
    {
        dropdown.selectByIndex(index);
    }

    public void selectByValue(String value)
    {
        dropdown.selectByValue(value);
    }


}
