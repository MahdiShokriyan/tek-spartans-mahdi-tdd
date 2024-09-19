package tek.tdd.api.test;

import com.aventstack.extentreports.service.ExtentTestManager;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.api.models.AccountType;
import tek.tdd.api.models.EndPoints;
import tek.tdd.api.models.UserProfileResponse;
import tek.tdd.base.ApiTestsBase;

public class UserProfileTest extends ApiTestsBase {

    @Test
    public void getUserSupervisorProfileTest() {
        String token = generateTokenOfSupervisor();
        Response response = getDefaultRequest()
                .header("Authorization", "Bearer " + token)
                .when().get(EndPoints.USER_PROFILE.getValue())
                .then().statusCode(200)
                .extract().response();
        response.prettyPrint();
        ExtentTestManager.getTest().info(response.asPrettyString());
        UserProfileResponse userProfileResponse = response.body().jsonPath().getObject
                ("", UserProfileResponse.class);
        Assert.assertNotNull(userProfileResponse);
        Assert.assertEquals(userProfileResponse.getFullName(), "Supervisor");
        Assert.assertEquals(userProfileResponse.getAuthorities().get(0).getRole(), "ADMIN");
        Assert.assertEquals(userProfileResponse.getAccountType(), AccountType.CSR, "Both should be the Same");

    }


    @Test
    public void getUserReadOnlyProfileTest() {
        String token = generateTokenOfSReadOnly();
        Response response = getDefaultRequest()
                .header("Authorization", "Bearer " + token)
                .when().get(EndPoints.USER_PROFILE.getValue())
                .then().statusCode(200)
                .extract().response();

        response.prettyPrint();
        ExtentTestManager.getTest().info(response.asPrettyString());
        UserProfileResponse userProfileResponse = response.body().jsonPath().getObject(
                "", UserProfileResponse.class);
        Assert.assertNotNull(userProfileResponse);
        Assert.assertEquals(userProfileResponse.getFullName(), "operator_readonly");
        Assert.assertEquals(userProfileResponse.getAuthorities().get(0).getRole(), "READ_ONLY");
        Assert.assertEquals(userProfileResponse.getAccountType(), AccountType.CSR, "Both should be the Same");


    }
}
