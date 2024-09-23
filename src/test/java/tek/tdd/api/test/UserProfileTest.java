package tek.tdd.api.test;

import com.aventstack.extentreports.service.ExtentTestManager;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.api.models.AccountType;
import tek.tdd.api.models.EndPoints;
import tek.tdd.api.models.UserProfileResponse;
import tek.tdd.base.ApiTestsBase;

public class UserProfileTest extends ApiTestsBase {

    @Test(dataProvider = "profileData")
    public void getUserSupervisorProfileTest(String username, String password,
                                             String expectedFullName, String expectedRole) {
        String token = generateValidToken(username, password);
        Response response = getDefaultRequest()
                .header("Authorization", token)
                .when().get(EndPoints.USER_PROFILE.getValue())
                .then().statusCode(200)
                .extract().response();
        response.prettyPrint();
        ExtentTestManager.getTest().info(response.asPrettyString());
        UserProfileResponse userProfileResponse = response.body().jsonPath().getObject
                ("", UserProfileResponse.class);
        Assert.assertNotNull(userProfileResponse);
        Assert.assertEquals(userProfileResponse.getFullName(), expectedFullName);
        Assert.assertEquals(userProfileResponse.getAuthorities().get(0).getRole(), expectedRole);
        Assert.assertEquals(userProfileResponse.getAccountType(), AccountType.CSR);

    }

    @DataProvider(name = "profileData")
    private String[][] profileDataForToken() {
        return new String[][]{
                {"supervisor", "tek_supervisor", "Supervisor", "ADMIN"},
                {"operator_readonly", "Tek4u2024", "operator_readonly", "READ_ONLY"}
        };
    }
}
