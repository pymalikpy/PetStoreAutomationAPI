package api.endpoints;

//Created to perform CRUD operations

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndPoints {

    public static Response createUser(User payload){

        if (payload == null) {
            throw new IllegalArgumentException("payload cannot be null");
        }
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

                .when()
                .post(routes.post_url);
        return response;

    }

    public static Response readUser(String username){

        Response response = given()
                .pathParam("username",username)

                .when()
                .get(routes.get_url);
        return response;

    }

    public static Response updateUser(String username, User payload){

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",username)
                .body(payload)

                .when()
                .put(routes.update_url);
        return response;

    }

    public static Response deleteUser(String username){

        Response response = given()
                .pathParam("username",username)

                .when()
                .delete(routes.delete_url);
        return response;

    }

}
