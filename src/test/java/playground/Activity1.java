package playground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity1 {
    private static WebDriver driver;

    @BeforeMethod
    public void openFacebook() {
        driver = new ChromeDriver();
        driver.get("https://microsoft.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void facebookTitle() {
        String applicationTitle = driver.getTitle();
        Assert.assertEquals(applicationTitle, "Facebook - log in or sign up");
    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }
}
