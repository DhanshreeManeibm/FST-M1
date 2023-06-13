package Examples;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
public class requestSpec {
    // Declare request specification
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    @BeforeClass
    public void setUp() {
        // Create request specification
        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .build();
        responseSpec = new ResponseSpecBuilder()
                // Check status code in response
                .expectStatusCode(200)
                // Check response content type
                .expectContentType("application/json")
                // Check if response//contains name property
                //.expectBody("status", Matchers.equalTo("alive"))
                // Build response specification
                .build();
    }

    @Test
    public void testPet1() {
        Response response =
                given().spec(requestSpec) // Use requestSpec
                        .pathParam("petId", "453637") // Set path parameter
                        .get("/{petId}"); // Send GET request

        // Print response
        String body = response.getBody().asPrettyString();
        System.out.println(body);

        // Assertion
        response.then().spec(responseSpec).body("name", equalTo("Riley"));
    }

    @Test
    public void testPet2() {
        Response response =
                given().spec(requestSpec) // Use requestSpec
                        .pathParam("petId", "453637") // Set path parameter
                        .when().delete("/{petId}"); // Send GET request

        // Print response
        String body = response.getBody().asPrettyString();
        System.out.println(body);

        // Assertion
        response.then().spec(responseSpec).body("message", equalTo(""+453637));
    }
}
