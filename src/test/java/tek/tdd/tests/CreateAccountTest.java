package tek.tdd.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;
import tek.tdd.utility.DataGenerator;

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
     signUpPage.fillUpCreateAccountForm("sorosh", expectedEmail,"Password@123");

        String actualEmail = getElementText(accountPage.emailTitle);

        Assert.assertEquals(actualEmail, expectedEmail, "Emails should Match");
    }

    @Test
    public void createAccountWithExistedAccount(){
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

}
