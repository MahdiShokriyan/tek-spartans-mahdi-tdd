package tek.tdd.base;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import tek.tdd.api.models.EndPoints;
import tek.tdd.api.models.TokenRequest;

import java.util.HashMap;
import java.util.Map;

@Listeners(ExtentITestListenerClassAdapter.class)
public class ApiTestsBase extends BaseSetup {
    private static final Logger LOGGER = LogManager.getLogger(ApiTestsBase.class);

    public RequestSpecification getDefaultRequest() {
        LOGGER.info("Sending API call to {}", RestAssured.baseURI);
        return RestAssured.given().contentType(ContentType.JSON);
    }

    public Map<String , String> getTokenRequestBody(String username , String password){
        Map<String , String > body = new HashMap<>();
        body.put("username", username);
        body.put("password", password);
        return body;
    }

    public String generateTokenOfSupervisor(){
        TokenRequest tokenRequest = new TokenRequest(
                "supervisor", "tek_supervisor");
       return getDefaultRequest()
                .body(tokenRequest)
                .when()
                .post(EndPoints.TOKEN.getValue())
                .then().statusCode(200)
                .extract()
                .response()
                .jsonPath().getString("token");

    }
    public String generateTokenOfSReadOnly(){
        TokenRequest tokenRequest = new TokenRequest(
                "operator_readonly", "Tek4u2024");
        return getDefaultRequest()
                .body(tokenRequest)
                .when()
                .post(EndPoints.TOKEN.getValue())
                .then().statusCode(200)
                .extract()
                .response()
                .jsonPath().getString("token");

    }


}
