package tek.tdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import tek.tdd.utility.SeleniumUtility;

public class AccountPage extends SeleniumUtility {

    public AccountPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(className = "account__information-email")
    public WebElement emailTitle;

    @FindBy(id = "nameInput")
    public WebElement nameInput;

    @FindBy(id = "personalPhoneInput")
    public WebElement phoneNumberInput;

    @FindBy(id = "personalUpdateBtn")
    public WebElement updateButton;

    @FindBy(className = "Toastify__toast-body")
    public WebElement toastifyLocator;

    @FindBy(className = "account__information-username")
    public WebElement accountUserNameText;


    public boolean isToastDisplayed() {
       return isElementDisplayed(toastifyLocator);

    }

    public void waitForSeconds(Integer seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
