import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreateUserTest {
    RestAssured.baseURI = "API URI";
    
    //JSON REQUEST BODY to create a new user
    String requestBody = "{"
    + "\"name\": \"John Doe\","
    + "\"email\": \"johndoe@example.com\""
    + "}";

    //REPONSE VALIDATION code 201,name validation and email validation
    Response response=given().header("Content-type","application/json").body(requestBody).when().post("/users");
    
    response.then().statusCode(201).body(name,equalTo("John Doe")).body("email", equalTo("johndoe@example.com"));
}