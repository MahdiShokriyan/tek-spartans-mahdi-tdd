package tek.tdd.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;

public class SecurityTest extends UIBaseClass {

    @Test
    public void userStory1() {
        clickOnButton(homePage.signInLink);
        String actualResult = getElementText(signInPage.signInTitle);
        Assert.assertEquals(actualResult, "Sign in",
                "the title Should be Sign in ");
        signInPage.doSignin("mahdi.mahdi1@gmail.com", "Password@123");
        boolean isDisplayed = isElementDisplayed(homePage.accountLink);
        Assert.assertTrue(isDisplayed);
    }

    @Test(dataProvider = "InvalidTestData")
    public void negativeSignInTests(String email, String password) {
        clickOnButton(homePage.signInLink);
        signInPage.doSignin(email, password);

        String actualErrorMessage = getElementText(signInPage.errorMessage);
        Assert.assertEquals(actualErrorMessage, "wrong username or password", "Error message should match");
    }

    @DataProvider(name = "InvalidTestData")
    private String[][] invalidTestData() {
        return new String[][]{
                {"mahdi.jan@gmail.coms", "Password@123"},
                {"mahdi.jan123@gmail.coms", "Password@123"},
                {"mahdi.jan1234@gmail.coms", "Password@123"},
        };
    }



}
