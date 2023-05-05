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
public class UserControllerIT {

    @LocalServerPort
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
    }


    @Test
    public void testLogin()
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

//        User response = RestAssured.given().
//                header("Content-Type", "text/plain").
//                header("charset", "utf-8").
//                body("").
//                when().
//                get("/users/2").thenReturn().as(User.class);

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

    @Test
    public void testGetUsers() {
        // Send request and receive response
        Response response = RestAssured.given().
                header("Content-Type", "text/plain").
                header("charset", "utf-8").
                body("").
                when().
                get("/users");

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }

    @Test
    public void getUserByID() {
        // Send request and receive response


        User response = RestAssured.given().
                header("Content-Type", "text/plain").
                header("charset", "utf-8").
                body("").
                when().
                get("/users/2").thenReturn().as(User.class);

        assertEquals("chuck", response.getName());

    }

    @Test
    public void getUserHobbyInterestNValue() {
        // Send request and receive response

        Response h = RestAssured.given().
                header("Content-Type", "text/plain").
                header("charset", "utf-8").
                body("").
                when().
                get("/users/2/hobby");

        int statusCodeH = h.getStatusCode();
        assertEquals(200, statusCodeH);

        Response i = RestAssured.given().
                header("Content-Type", "text/plain").
                header("charset", "utf-8").
                body("").
                when().
                get("/users/2/interest");

        int statusCodeI = i.getStatusCode();
        assertEquals(200, statusCodeI);

        Response v = RestAssured.given().
                header("Content-Type", "text/plain").
                header("charset", "utf-8").
                body("").
                when().
                get("/users/2/value");

        int statusCodeV = v.getStatusCode();
        assertEquals(200, statusCodeV);
    }

    @Test
    public void getUserFriend() {
        // Send request and receive response

        Response response = RestAssured.given().
                header("Content-Type", "text/plain").
                header("charset", "utf-8").
                body("").
                when().
                get("/users/117/friends");

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);

        User[] friend = RestAssured.given().
                header("Content-Type", "text/plain").
                header("charset", "utf-8").
                body("").
                when().
                get("/users/117/friends").thenReturn().as(User[].class);

        assertEquals(119, friend[0].getId());
    }

    @Test
    public void getUserGroup() {
        // Send request and receive response

        Group[] response = RestAssured.with().
                when().
                get("/users/117/groups").thenReturn().as(Group[].class);

        //int statusCode = response.getStatusCode();
        assertEquals(129, response[0].getId());
    }

    @Test
    public void createAndDeleteUser() {
        // Send request and receive response

        //CREATE
        User u = new User("bobby", "123456", "bob", "bob@gmail.com", "M", "515-443-3763");
        User createdA = RestAssured.given().
                header("Content-Type", "text/plain").
                header("charset", "utf-8").
                contentType("application/json").
                body(u).
                when().
                post("/users").thenReturn().as(User.class);
        assertEquals("bob", createdA.getName());



        //DELETE
        Response response = RestAssured.given().
                header("Content-Type", "text/plain").
                header("charset", "utf-8").
                body("").
                when().
                delete("/users/"+createdA.getId());

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);

        //int statusCode = created.getStatusCode();
        //assertEquals(200, statusCode);
    }

//    @Test
//    public void updateUser() {
//        // Send request and receive response
//        //TODO
//
//        Response response = RestAssured.given().
//                header("Content-Type", "text/plain").
//                header("charset", "utf-8").
//                body("").
//                when().
//                get("/users/login/a2/password");
//
//        int statusCode = response.getStatusCode();
//        assertEquals(200, statusCode);
//    }

//    @Test
//    public void getMatch() {
//        // Send request and receive response
//        //TODO
//
//        Response response = RestAssured.given().
//                header("Content-Type", "text/plain").
//                header("charset", "utf-8").
//                body("").
//                when().
//                get("/users/login/a2/password");
//
//        int statusCode = response.getStatusCode();
//        assertEquals(200, statusCode);
//    }

//    @Test
//    public void addUserToGroup() {
//        // Send request and receive response
//        //TODO
//
//        Response response = RestAssured.given().
//                header("Content-Type", "text/plain").
//                header("charset", "utf-8").
//                body("").
//                when().
//                get("/users/login/a2/password");
//
//        int statusCode = response.getStatusCode();
//        assertEquals(200, statusCode);
//    }

//    @Test
//    public void addHobbyToUser() {
//        // Send request and receive response
//        //TODO
//
//        Response response = RestAssured.given().
//                header("Content-Type", "text/plain").
//                header("charset", "utf-8").
//                body("").
//                when().
//                get("/users/login/a2/password");
//
//        int statusCode = response.getStatusCode();
//        assertEquals(200, statusCode);
//    }

//    @Test
//    public void deleteUser() {
//        // Send request and receive response
//        //TODO
//
//        Response response = RestAssured.given().
//                header("Content-Type", "text/plain").
//                header("charset", "utf-8").
//                body("").
//                when().
//                get("/users/login/a2/password");
//
//        int statusCode = response.getStatusCode();
//        assertEquals(200, statusCode);
//    }

}
