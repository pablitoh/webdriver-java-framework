package APITests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ExampleAPITest {

    private final String  BASE_URL  = "https://reqres.in";

    /***
     * Basic API TEST example.
     */
    @Test
    public void testAPIExample()
    {
        given()
                .get(BASE_URL + "/api/users?page=2").
                then().statusCode(200).log().all();
    }

    
}
