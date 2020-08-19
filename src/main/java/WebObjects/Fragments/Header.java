package WebObjects.Fragments;

import UiElements.UiElement;
import WebObjects.Pages.ContactUsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public class Header {

    private UiElement contactUs_button = new UiElement(By.id("contact-link"));

    /***
     * Clicks on the contact us link in the header
     * @return
     */
    @Step("Clicking Contact Us in the header")
    public ContactUsPage click_contact_us()
    {
        contactUs_button.click();
        return new ContactUsPage();
    }





}
