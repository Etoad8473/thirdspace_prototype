package main.TESTING;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class UserTest {

    @LocalServerPort
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
    }


    @Test
    public void wrongPassword()
    {
        // Send request and receive response
        Response response = RestAssured.given().
                header("Content-Type", "text/plain").
                header("charset", "utf-8").
                body("").
                when().
                get("/users/login/a2/password");

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);

//        // Check response body for correct response
//        String returnString = response.getBody().asString();
//        try {
//            System.out.println(returnString);
//            JSONObject returnObj = new JSONObject(returnString);
//            System.out.println(returnObj);
//            //assertEquals(null, returnObj.);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
    }

}
