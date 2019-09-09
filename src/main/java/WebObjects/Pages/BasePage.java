package WebObjects.Pages;

import WebObjects.Fragments.Header;

public class BasePage {
    private Header header = new Header();

    public Header getHeader() {
        return header;
    }

    public ContactUsPage goTo_ContactUs()
    {
        getHeader().click_contact_us();
        return new ContactUsPage();
    }
}
