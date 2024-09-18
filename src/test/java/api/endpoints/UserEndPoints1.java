package api.endpoints;

//Created to perform CRUD operations

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UserEndPoints1 {

    public static ResourceBundle getURL(){
        ResourceBundle routes = ResourceBundle.getBundle("routes");
        return routes;
    }

    public static Response createUser(User payload){

        String postURL = getURL().getString("post_url");

        if (payload == null) {
            throw new IllegalArgumentException("payload cannot be null");
        }
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

                .when()
                .post(postURL);
        return response;

    }

    public static Response readUser(String username){

        String getURL = getURL().getString("get_url");

        Response response = given()
                .pathParam("username",username)

                .when()
                .get(getURL);
        return response;

    }

    public static Response updateUser(String username, User payload){
        String updateURL = getURL().getString("update_url");

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",username)
                .body(payload)

                .when()
                .put(updateURL);
        return response;

    }

    public static Response deleteUser(String username){
        String deleteURL = getURL().getString("delete_url");

        Response response = given()
                .pathParam("username",username)

                .when()
                .delete(deleteURL);
        return response;

    }

}
