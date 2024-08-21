package tek.tdd.tests;

import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;

public class AccountProfileTest extends UIBaseClass {

    @Test
    public void changeNameAndPhoneInProfilePage() {
        clickOnButton(homePage.signInLink);
        signInPage.doSignin("mahdi@gmail.com", "Password@123");
        clickOnButton(homePage.accountLink);
        sendText(accountPage.nameInput, "mark");
        sendText(accountPage.phoneNumberInput, "5715724354");
        clickOnButton(accountPage.updateButton);
        accountPage.isToastDisplayed();
        accountPage.waitForSeconds(6);
        sendText(accountPage.nameInput, "John");
        sendText(accountPage.phoneNumberInput, "9871234567");
        clickOnButton(accountPage.updateButton);
        accountPage.isToastDisplayed();
    }
}
