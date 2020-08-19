package WebObjects.Fragments;

import UiElements.UiElement;
import WebObjects.Pages.ContactUsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public class Header {

    private UiElement contactUs_button = new UiElement(By.id("contact-link"));

    public ContactUsPage click_contact_us()
    {
        contactUs_button.click();
        return new ContactUsPage();
    }





}
