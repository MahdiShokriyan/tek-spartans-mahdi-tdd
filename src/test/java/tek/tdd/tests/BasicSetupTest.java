package tek.tdd.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;
import tek.tdd.pages.HomePage;

public class BasicSetupTest extends UIBaseClass {

    public void validateLog(){
         String actualLogoText = getElementText(homePage.topLeftLogo);
        Assert.assertEquals(actualLogoText, "TEKSCHOOL", "Logo Text should match");
    }
    @Test
    public void validateTopLeftCorner() {
        validateLog();
    }

    @Test
    public void validateSignInButtonIsEnable() {
        validateLog();
        boolean isEnabled = isElementEnable(homePage.signInLink);
        Assert.assertTrue(isEnabled, "the Button should be Enable");
    }



}
