package controllers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import twin.Group.Group;
import twin.TwinApplication;
import twin.User.User;

import static org.junit.Assert.assertEquals;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = TwinApplication.class)
@RunWith(SpringRunner.class)
public class InterestControllerIT {

    @LocalServerPort
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
    }


    @Test
    public void testInterest() {
        // Send request and receive response

        Response response = RestAssured.given().
                header("Content-Type", "text/plain").
                header("charset", "utf-8").
                body("").
                when().
                get("/interest");

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);

        Response responseA = RestAssured.given().
                header("Content-Type", "text/plain").
                header("charset", "utf-8").
                body("").
                when().
                get("/interest/65");

        int statusCodeA = responseA.getStatusCode();
        assertEquals(200, statusCodeA);
    }
}
