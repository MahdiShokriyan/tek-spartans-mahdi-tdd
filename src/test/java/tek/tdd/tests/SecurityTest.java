package tek.tdd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;
import tek.tdd.pages.HomePage;
import tek.tdd.pages.SignInPage;
import tek.tdd.utility.SeleniumUtility;

public class SecurityTest extends UIBaseClass {

    @Test
    public void userStory1() {
        clickOnButton(homePage.signInLink);
        String actualResult = getElementText(signInPage.signInTitle);
        Assert.assertEquals(actualResult, "Sign in",
                "the title Should be Sign in ");
        sendText(signInPage.email, "mahdi.mahdi1@gmail.com");
        sendText(signInPage.password, "Mahdi123!");
        clickOnButton(signInPage.loginButton);
        boolean isDisplayed = isElementDisplayed(homePage.accountLink);
        Assert.assertTrue(isDisplayed);
    }

}
