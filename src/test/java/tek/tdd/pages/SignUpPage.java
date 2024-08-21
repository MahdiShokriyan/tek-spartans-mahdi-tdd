package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

import java.util.List;

public class SignUpPage extends SeleniumUtility {

    public SignUpPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "nameInput")
    public WebElement nameInput;

    @FindBy(id = "emailInput")
    public WebElement emailInput;

    @FindBy(id = "passwordInput")
    public WebElement passwordInput;

    @FindBy(id = "confirmPasswordInput")
    public WebElement confirmPasswordInput;

    @FindBy(id = "signupBtn")
    public WebElement signUpBtn;

    @FindBy(className = "error")
    public WebElement signUpError;

    @FindBy(className = "nameError")
    public WebElement nameError;

    @FindBy(className = "emailError")
    public WebElement emailError;

    @FindBy(className = "passwordError")
    public WebElement passwordError;

    @FindBy(className = "confirmPasswordError")
    public WebElement confirmPasswordError;

    @FindBy(className = "error")
    public List<WebElement> allErrorsElements;



    public void fillUpCreateAccountForm(String name, String email, String password) {
        sendText(nameInput, name);
        sendText(emailInput, email);
        sendText(passwordInput, password);
        sendText(confirmPasswordInput, password);

        clickOnButton(signUpBtn);
    }
}
