package tek.tdd.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.tdd.base.BaseSetup;

import java.time.Duration;

public class SeleniumUtility extends BaseSetup {
    private static final Logger LOGGER = LogManager.getLogger(SeleniumUtility.class);

    private WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(WAIT_TIME_IN_SECOND));
    }

    private WebElement waitForVisibilityByElement(By locator) {

        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getElementText(By locator) {
        LOGGER.debug("Returning element Text {}", locator);
        return waitForVisibilityByElement(locator).getText();
    }

    public String getElementText(WebElement element) {
        LOGGER.debug("Returning element Text {}", element);
        return getWait().until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public void clickOnButton(By locator) {
        LOGGER.info("you Click on an element {}", locator);
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void clickOnButton(WebElement element) {
        LOGGER.info("you Click on an element {}", element);
        getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public boolean isElementEnable(By locator) {
        LOGGER.debug("checking element have enable status {}", locator);
        boolean isEnabled = waitForVisibilityByElement(locator).isEnabled();
        LOGGER.debug(" element is enables status {}", isEnabled);
        return isEnabled;
    }

    public boolean isElementEnable(WebElement element) {
        LOGGER.debug("checking element have enable status {}", element);
        boolean isEnabled = getWait().until(ExpectedConditions.visibilityOf(element)).isEnabled();
        LOGGER.debug(" element is enables status {}", isEnabled);
        return isEnabled;
    }

    public void sendText(WebElement element, String text) {
        LOGGER.debug("Sending text {} to Element {}", text, element);
       WebElement targetElement = getWait().until(ExpectedConditions.visibilityOf(element));
       targetElement.clear();
       targetElement.sendKeys(text);
    }
    public boolean isElementDisplayed(WebElement element){
        LOGGER.debug("Checking element Enabled status {} ", element);
        return getWait().until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

}
