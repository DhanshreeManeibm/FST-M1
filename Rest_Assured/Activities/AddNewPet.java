package Examples;

import static io.restassured.RestAssured.given;

import static org.hamcrest.CoreMatchers.equalTo;



import org.testng.annotations.Test;



import io.restassured.http.ContentType;

import io.restassured.response.Response;



public class AddNewPet {
    @Test
    public void AddNewPet() {
        // Set Base URL
        String ROOT_URI = "https://petstore.swagger.io/v2/pet";
        // Write the request body
        String reqBody = "{\"id\": 453637,\"name\": \"Riley\",\"status\": \"alive\"}";

        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .body(reqBody).when().post(ROOT_URI); // Send POST request

        // Print response of POST request
        String body = response.getBody().asPrettyString();
        System.out.println(body);
    }
}