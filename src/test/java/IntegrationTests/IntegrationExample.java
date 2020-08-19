package IntegrationTests;

import UiTests.BaseTest;
import WebObjects.Pages.ContactUsPage;
import WebObjects.Pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.response.Response;
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

    @Description("Tests the API and uses the information retrieved to fill the application contact us form.")
    @Story("PBI-0001")
    @Test
    public void test_integration()
    {
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
        HomePage home = new HomePage();
        ContactUsPage contactUsPage = home.goToContactUs();
        contactUsPage.
                typeEmail(response.path("data[0].email").toString()).
                typeOrderReference("F404").
                selectSubjectHeading("Webmaster").
                typeMessage(response.path("data[0].first_name").toString() + response.path("data[0].last_name").toString()).
                uploadFile(System.getProperty("user.dir")+"/src/resources/toy2.png").
                submitForm();
        /***
         * Asserts that the  form is filled correctly.
         */
        assertThat(contactUsPage.getResultMessage(),is("Your message has been successfully sent to our team."));

    }
}
