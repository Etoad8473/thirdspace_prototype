package test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.testng.AssertJUnit.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@RunWith(SpringRunner.class)
public class hobbyTest {

    @LocalServerPort
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
    }

//    @Test
//    public void createHobby() {
//
//        // Send request and receive response
//        Response response = RestAssured.given().
//                header("Content-Type", "text/plain").
//                header("charset", "utf-8").
//                body("").
//                when().
//                get("/users/id/58");
//
//
//        // Check status code
//        int statusCode = response.getStatusCode();
//        assertEquals(200, statusCode);
//
//        // Check response body for correct response
//        String returnString = response.getBody().asString();
//        try {
//            JSONObject returnObj = new JSONObject(returnString);
//            assertEquals("failed", returnObj.get("username"));
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void getAllHobbies()
    {
        // Send request and receive response
        Response response = RestAssured.given().
                header("Content-Type", "text/plain").
                header("charset", "utf-8").
                body("").
                when().
                get("/hobby");

        // Check response body for correct response
        String returnString = response.getBody().asString();
        try {
            JSONObject returnObj = new JSONObject(returnString);
            //assertEquals(, returnObj.getJSONArray("hobbyN").length());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
