package WebObjects.Pages;

import Utilities.Browser;
import WebObjects.Fragments.Header;

public class HomePage extends BasePage{

    private Header header = new Header();

    public HomePage(String url){
        Browser.open(url);
    }

    public ContactUsPage goToContactUs()
    {
        return header.click_contact_us();
    }




}
