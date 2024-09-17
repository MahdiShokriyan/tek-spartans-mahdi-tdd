package tek.tdd.api.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import tek.tdd.base.ApiTestsBase;

import java.util.HashMap;
import java.util.Map;

public class TokenGenerationTests extends ApiTestsBase {

    public void loginCredential(String username, String password) {
        RequestSpecification request = getDefaultRequest();
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("username", "username");
        requestBody.put("password", "password");
        request.body(requestBody);

        Response response = request.when().post("/api/token");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getValidToken() {
        loginCredential("supervisor", "tek_supervisor");
    }

    @Test
    public void getReadOnlyToken() {
        loginCredential("operator_readonly", "Tek4u2024");
    }
}
