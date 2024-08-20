package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class AccountPage extends SeleniumUtility {

    public AccountPage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(className = "account__information-email")
    public WebElement emailTitle;
}
