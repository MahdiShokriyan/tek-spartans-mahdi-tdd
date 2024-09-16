package tek.tdd.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tek.tdd.base.UIBaseClass;
import tek.tdd.utility.DataGenerator;

import java.util.Arrays;
import java.util.List;

public class CreateAccountTest extends UIBaseClass {


       /*
    CreateAccountTest
    Story 4: Navigate to Create Account page and Create new Account
    Validate New Account Created.
    */

    @Test
    public void createAccount() {
        String expectedEmail = DataGenerator.RandomEmailGenerator("sorosh");
        clickOnButton(homePage.signInLink);
        clickOnButton(signInPage.createNewAccountBtn);
        signUpPage.fillUpCreateAccountForm("sorosh", expectedEmail, "Password@123");

        String actualEmail = getElementText(accountPage.emailTitle);

        Assert.assertEquals(actualEmail, expectedEmail, "Emails should Match");
    }

    @Test
    public void createAccountWithExistedAccount() {
        clickOnButton(homePage.signInLink);
        clickOnButton(signInPage.createNewAccountBtn);
        signUpPage.fillUpCreateAccountForm("mahdi",
                "Mahdi.mahdi1@gmail.com",
                "Password@123");

        String actualResult = getElementText(signUpPage.signUpError);
        Assert.assertEquals(actualResult,
                "this email is already exist, please use another email address",
                "both Massage should be the same");
    }

    @Test
    public void validateAllError() {
        clickOnButton(homePage.signInLink);
        clickOnButton(signInPage.createNewAccountBtn);
        clickOnButton(signUpPage.signUpBtn);

        List<WebElement> actualErrorList = signUpPage.allErrorsElements;
        SoftAssert softAssert = new SoftAssert();
        List<String> expectedResult = Arrays.asList("Name is a required field",
                "Email is a required field",
                "Password is a required field",
                "Confirm Password is a required field");

        softAssert.assertEquals(actualErrorList.size(), expectedResult.size());

        for (int i = 0; i < actualErrorList.size(); i++) {
            softAssert.assertEquals(
                    getElementText(actualErrorList.get(i)),
                    expectedResult.get(i));
        }
softAssert.assertAll();
    }

}
