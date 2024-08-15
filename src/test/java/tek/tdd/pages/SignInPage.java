package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class SignInPage extends SeleniumUtility {

    public SignInPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//h1[text() ='Sign in']")
    public WebElement signInTitle;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(id = "loginBtn")
    public WebElement loginButton;
}
