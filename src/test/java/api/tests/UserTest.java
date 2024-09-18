package api.tests;

import api.endpoints.UserEndPoints;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTest {

    Faker faker;
    User userPayload;
    org.apache.logging.log4j.Logger logger;

    @BeforeClass
    public void setup(){
        faker = new Faker();
        userPayload = new User();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5,10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());
        System.out.println(userPayload.getUsername());

        //logging info

        logger = LogManager.getLogger(this.getClass());

    }

    @Test(priority = 1)
    public void testPostUser(){

        logger.info("******Creating a user*****");

        Response response = UserEndPoints.createUser(userPayload);
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println(response.jsonPath().prettify());

        logger.info("*****User is created*******");
    }

    @Test(priority = 2)
    public void testGetUserByName(){
        //logger.info("User details are following");
        Response response = UserEndPoints.readUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test(priority = 3)
    public void testUpdateUserByName(){
        logger.info("Updated user details");
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        Response response = UserEndPoints.updateUser(userPayload.getUsername(), userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        Response response1 = UserEndPoints.readUser(this.userPayload.getUsername());
        response1.then().log().all();

    }

    @Test(priority = 4)
    public void testDeleteUserByName(){
        Response response = UserEndPoints.deleteUser(userPayload.getUsername());
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("User is deleted");
    }
}
