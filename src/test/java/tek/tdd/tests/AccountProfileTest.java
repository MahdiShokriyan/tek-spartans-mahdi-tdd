package tek.tdd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;

public class AccountProfileTest extends UIBaseClass {

    @Test
    public void changeNameAndPhoneInProfilePage() {
        clickOnButton(homePage.signInLink);
        signInPage.doSignin("mahdi@gmail.com", "Password@123");
        clickOnButton(homePage.accountLink);
        sendText(accountPage.nameInput, "mahdi");
        sendText(accountPage.phoneNumberInput, "1234567890");
        clickOnButton(accountPage.updateButton);
        Assert.assertTrue(accountPage.isToastDisplayed());
        String actualUserName = getElementText(accountPage.accountUserNameText);
        Assert.assertEquals(actualUserName, "mahdi", "both name should be the same");
        accountPage.waitForSeconds(6);
        sendText(accountPage.nameInput, "Doe John");
        sendText(accountPage.phoneNumberInput, "9871234578");
        clickOnButton(accountPage.updateButton);
        Assert.assertTrue(accountPage.isToastDisplayed());
        String actualUserNameRevert = getElementText(accountPage.accountUserNameText);
        Assert.assertEquals(actualUserNameRevert, "Doe John", "both name should be the same");

    }
}
