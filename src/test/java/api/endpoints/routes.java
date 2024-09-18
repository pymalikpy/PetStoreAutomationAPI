package api.endpoints;

//Base URL: https://petstore.swagger.io/v2
//Create user (Post): https://petstore.swagger.io/v2/user
//Get user(Get): https://petstore.swagger.io/v2/user/{username}
//Update user(Put): https://petstore.swagger.io/v2/user/{username}
//Delete user(Delete): https://petstore.swagger.io/v2/user/{username}

public class routes {

    // URLs for user module

    public static String base_url = "https://petstore.swagger.io/v2";
    public static String post_url = base_url + "/user";
    public static String get_url = post_url + "/{username}";
    public static String update_url = get_url;
    public static String delete_url = update_url;


    // Store module
       //here add endpoints for store module

    // Pet module
      // here add endpoints for pet module


}
