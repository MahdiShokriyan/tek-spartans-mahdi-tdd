package tek.tdd.api.test;

import com.aventstack.extentreports.service.ExtentTestManager;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.api.models.EndPoints;
import tek.tdd.base.ApiTestsBase;

public class GetPrimaryAccountTest extends ApiTestsBase {

    @Test
    public void getAccountAndValidate() {
        RequestSpecification requestSpecification = getDefaultRequest();
        requestSpecification.queryParam("primaryPersonId", 777);

        Response response = requestSpecification.when().get(EndPoints.GET_PRIMARY_ACCOUNT.getValue());
        response.then().statusCode(200);
        ExtentTestManager.getTest().info(response.prettyPrint());

        String actualEmail = response.jsonPath().getString("email");
        Assert.assertEquals(actualEmail, "Ellaha_jaan_4984620@tekschool.us");
    }

    @Test
    public void validateGetAccountNotExist() {
      Response response =  getDefaultRequest()
                .queryParam("primaryPersonId", 100)
                .when().get(EndPoints.GET_PRIMARY_ACCOUNT.getValue())
                .then().statusCode(404)
                .extract().response();
        String errorMessage = response.body().jsonPath().getString("errorMessage");
        response.prettyPrint();
        Assert.assertEquals(errorMessage, "Account with id 100 not exist");
    }


}
