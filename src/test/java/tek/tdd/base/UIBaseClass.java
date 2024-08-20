package tek.tdd.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import tek.tdd.pages.AccountPage;
import tek.tdd.pages.HomePage;
import tek.tdd.pages.SignInPage;
import tek.tdd.pages.SignUpPage;
import tek.tdd.utility.SeleniumUtility;

public class UIBaseClass extends SeleniumUtility {
    private static final Logger LOGGER = LogManager.getLogger(UIBaseClass.class);
    public HomePage homePage;
    public SignInPage signInPage;
    public SignUpPage signUpPage;
    public AccountPage accountPage;

    @BeforeMethod
    public void setupTests() {
        LOGGER.info("Setup test and opening browser");
        setupBrowser();
        homePage = new HomePage();
        signInPage = new SignInPage();
        signUpPage = new SignUpPage();
        accountPage = new AccountPage();

    }

    @AfterMethod
    public void testCleanup() {
        LOGGER.info("running after each test and quit browser");
        quitBrowser();
    }

}
