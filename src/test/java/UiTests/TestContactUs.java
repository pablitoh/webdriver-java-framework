package UiTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import WebObjects.Pages.ContactUsPage;
import WebObjects.Pages.HomePage;

public class TestContactUs extends BaseTest {

    /***
     * DEMO TEST. TODO:
     *
     * - Retry Analizer
     * - DataProvider
     */

    @Test
    public void first_test() {
        HomePage home = new HomePage("http://automationpractice.com/index.php");
        ContactUsPage contactUsPage = home.goTo_ContactUs();
        contactUsPage.
                typeEmail("test@test.com").
                typeOrderReference("F404").
                selectSubjectHeading("Webmaster").
                typeMessage("Complaint about order F404").
                uploadFile("/Users/pabloconde/Pablo/DEV/testproject/src/resources/toy2.png").
                submitForm();
        Assert.assertEquals(contactUsPage.getResultMessage(),
                "Your message has been successfully sent to our team.");
    }

    @Test
    public void second_test() {
        HomePage home = new HomePage("http://automationpractice.com/index.php");
        home.goTo_ContactUs();
    }

    @Test
    public void third_test() {
        HomePage home = new HomePage("http://automationpractice.com/index.php");
        home.goTo_ContactUs();
    }


}
