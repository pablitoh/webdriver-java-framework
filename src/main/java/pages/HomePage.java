package pages;

import components.UiElement;
import org.openqa.selenium.By;



public class HomePage {

    private UiElement contactUs_button = new UiElement(By.id("contact-link"));

    public HomePage(){

    }

    public void click_contact_us()
    {
        contactUs_button.click();
    }





}
