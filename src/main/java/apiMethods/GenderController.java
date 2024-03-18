package apiMethods;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

/**
 * @author Bakai Saitkulov
 */


public class GenderController {

    private RequestSpecification spec;

    public GenderController(String baseUrl){
        this.spec = given()
                .baseUri(baseUrl);
    }

    public Response get(String endpoint){
        return given()
                .spec(this.spec)
                .get(endpoint);
    }

}
