package UiTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import WebObjects.Pages.ContactUsPage;
import WebObjects.Pages.HomePage;

import java.util.ArrayList;
import java.util.List;

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
        ContactUsPage contactUsPage = home.goToContactUs();
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
        home.goToContactUs();
    }

    @Test
    public void third_test() {

        List<String> data = new ArrayList<String>();
        data.add("thooosee whoo dare to challengee meee");
        data.add("Test String");
        data.add("Moreeee moreeee text MUAJAJAJAAA");

        for(String text:data)
        {
            System.out.println("Text           : " + text);
            System.out.println("Compressed text: " + compress(text));
        }

    }


    public static String compress(String text) {
        String compressedString = text;
        String stringToReplace = "";
        for (int i = 0; i <= text.length() - 1; i++) {

            if ((i != text.length() - 1) && text.charAt(i) == text.charAt(i + 1)
                    && (stringToReplace.equals("") || stringToReplace.charAt(0) == text.charAt(i))) {
                stringToReplace += text.charAt(i);
            } else
                {
                if (i > 0 && text.charAt(i - 1) == text.charAt(i) && stringToReplace.charAt(0) == text.charAt(i)) {
                    stringToReplace += text.charAt(i);
                }
                else if(!stringToReplace.equals(""))
                {
                    break;
                }
            }
        }
        if (!stringToReplace.equals("")) {

            compressedString = text.replaceFirst(stringToReplace, Integer.toString(stringToReplace.length()));
            compressedString = compress(compressedString);
        }
        return compressedString;
    }


}
