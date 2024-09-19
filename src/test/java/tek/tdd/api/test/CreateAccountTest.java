package tek.tdd.api.test;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.api.models.AddAccountRequest;
import tek.tdd.api.models.EndPoints;
import tek.tdd.base.ApiTestsBase;
import tek.tdd.utility.DataGenerator;

public class CreateAccountTest extends ApiTestsBase {

    @Test
    public void addPrimaryAccount() {

       String email = DataGenerator.RandomEmailGenerator("California");
        AddAccountRequest bodyRequest = new AddAccountRequest(
                email,
                "Caleb", "Jahan", "Mrs.", "Female",
                "Single", "jobless", "1990-09-30"
        );
        Response response = getDefaultRequest()
                .body(bodyRequest)
                .when().post(EndPoints.ADD_PRIMARY_ACCOUNT.getValue())
                .then().statusCode(201)
                .extract().response();
        String actualFirstName = response.jsonPath().getString("firstName");
        response.prettyPrint();
        Assert.assertEquals(actualFirstName, "Caleb");
    }
}
