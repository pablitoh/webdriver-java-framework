package IntegrationTests;

import UiTests.BaseTest;
import WebObjects.Pages.ContactUsPage;
import WebObjects.Pages.HomePage;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

/***
 * Basic UI/API Integration test example
 * @author pabloconde
 */
public class IntegrationExample extends BaseTest {

    private final String  BASE_URL  = "https://reqres.in";

    @Test
    public void test_integration()
    {

        HomePage home = new HomePage("http://automationpractice.com/index.php");
        ContactUsPage contactUsPage = home.goTo_ContactUs();

        /**
         * Gets and validates the response from the API
         */
        Response response = given().get(BASE_URL + "/api/users?page=2").
                then().statusCode(200).log().all().
                extract().
                response();
        /***
         * Utilizes data from  the previous request to fill UI data.
         */
        contactUsPage.
                typeEmail(response.path("data[0].email").toString()).
                typeOrderReference("F404").
                selectSubjectHeading("Webmaster").
                typeMessage(response.path("data[0].first_name").toString() + response.path("data[0].last_name").toString()).
                uploadFile("/Users/pabloconde/Pablo/DEV/testproject/src/resources/toy2.png").
                submitForm();

        /***
         * Asserts that the  form is filled correctly.
         */
        assertThat(contactUsPage.getResultMessage(),is("Your message has been successfully sent to our team."));

    }
}
