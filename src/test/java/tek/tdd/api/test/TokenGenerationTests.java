package tek.tdd.api.test;

import com.aventstack.extentreports.service.ExtentTestManager;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.api.models.AccountType;
import tek.tdd.api.models.EndPoints;
import tek.tdd.api.models.TokenRequest;
import tek.tdd.api.models.TokenResponse;
import tek.tdd.base.ApiTestsBase;

import java.util.Map;

public class TokenGenerationTests extends ApiTestsBase {
    public static final Logger LOGGER = LogManager.getLogger(TokenGenerationTests.class);

    public Response loginWithCredential(String username, String password) {
        RequestSpecification requestSpecification = getDefaultRequest();
        Map<String, String> body = getTokenRequestBody(username, password);
        requestSpecification.body(body);
        //Send request to /api/token
        return requestSpecification.when().post(EndPoints.TOKEN.getValue());

    }

    //Create a test validate token generated with supervisor User
    @Test(dataProvider = "credentials")
    public void generateValidToken(String username, String password) {
        Response response = loginWithCredential(username, password);
        response.then().statusCode(200);
        LOGGER.info("Response is {}", response.asPrettyString());
    }

    @DataProvider(name = "credentials")
    private String[][] credentials() {
        return new String[][]{
                {"supervisor", "tek_supervisor"},
                {"operator_readonly", "Tek4u2024"},
        };
    }

    @Test(dataProvider = "wrongCredentials")
    public void logInWithWrongCredential(String username, String password, int statusCode,
                                         String errorMessage) {
        Response response = loginWithCredential(username, password);
        response.then().statusCode(statusCode);

        String actualErrorMessage = response.body().jsonPath().getString("errorMessage");
        Assert.assertEquals(actualErrorMessage, errorMessage, "both should match");
    }

    @DataProvider(name = "wrongCredentials")
    private Object[][] wrongCredentials() {
        return new Object[][]{
                {"wrongUserName", "tek_supervisor", 404, "User wrongUserName not found"},
                {"supervisor", "wrongPassword", 400, "Password not matched"},
        };
    }

    @Test
    public void generateTokenUseObjectAsBody() {
        RequestSpecification request = getDefaultRequest();

        TokenRequest requestBody = new TokenRequest("supervisor", "tek_supervisor");

        request.body(requestBody);

        Response response = request.when().post(EndPoints.TOKEN.getValue());

        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void convertResponseToPOJO() {
        TokenRequest tokenRequest = new TokenRequest("supervisor", "tek_supervisor");
        Response response = getDefaultRequest()
                .body(tokenRequest)
                .when().post(EndPoints.TOKEN.getValue())
                .then().statusCode(200)
                .extract().response();
        ExtentTestManager.getTest().info(response.asPrettyString());

        TokenResponse token = response.body().jsonPath().getObject("", TokenResponse.class);
        Assert.assertEquals(token.getUsername(), "supervisor");
        Assert.assertNotNull(token.getToken());
        Assert.assertEquals(token.getAccountType(), AccountType.CSR);

    }

}
