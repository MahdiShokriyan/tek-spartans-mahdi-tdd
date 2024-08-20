package tek.tdd.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;

public class CreateAccountTest extends UIBaseClass {

       /*
    CreateAccountTest
    Story 4: Navigate to Create Account page and Create new Account
    Validate New Account Created.
    */

    @Test(dataProvider = "CreateAccountData")
    public void createAccount(String name, String email, String password) {
        clickOnButton(homePage.signInLink);
        clickOnButton(signInPage.createNewAccountBtn);
        sendText(signUpPage.nameInput, name);
        sendText(signUpPage.emailInput, email);
        sendText(signUpPage.passwordInput, password);
        sendText(signUpPage.confirmPasswordInput, password);
        clickOnButton(signUpPage.signUpBtn);

        String actualEmail = getElementText(accountPage.emailTitle);

        Assert.assertEquals(actualEmail, email, "Emails should Match");
    }

    public static String RandomEmailGenerator(String name) {

        int randomNumber = (int) (Math.random() * 10000);
        return name + randomNumber + "@gmail.com";
    }

    @DataProvider(name = "CreateAccountData")
    private String[][] createNewAccountData() {
        return new String[][]{
                {"John", RandomEmailGenerator("John"), "Password@123"},
                {"John", RandomEmailGenerator("John"), "Password@123"},
                {"John", RandomEmailGenerator("John"), "Password@123"},
                {"John", RandomEmailGenerator("John"), "Password@123"},
        };
    }

}
