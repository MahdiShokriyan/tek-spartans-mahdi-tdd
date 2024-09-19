package tek.tdd.base;

import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public abstract class BaseSetup {
    //read config file
    private static final Logger LOGGER = LogManager.getLogger(BaseSetup.class);
    protected static final long WAIT_TIME_IN_SECOND = 15;

    private static WebDriver driver;
    private final Properties properties;

    public BaseSetup(){
       String configFilePath = System.getProperty("user.dir") +
               "/src/test/resources/configs/dev-config.properties";
       try{
           LOGGER.debug("Reading Config file from path {}", configFilePath);
           InputStream inputStream = new FileInputStream(configFilePath);
           properties = new Properties();
           properties.load(inputStream);

           RestAssured.baseURI = properties.getProperty("api.url");

       }catch (IOException ioException){
           LOGGER.error("Config file error with message{}", ioException.getMessage());
           throw new RuntimeException("Config file error with message"+ ioException.getMessage());
       }
    }
    public void setupBrowser() {
        String url = properties.getProperty("ui.url");
        String browserType = properties.getProperty("ui.browser");
        boolean isHeadless = Boolean.parseBoolean(properties.getProperty("ui.browser.headless"));
        LOGGER.info("Opening on {} browser", browserType);
        LOGGER.info("Is Headless ON {}", isHeadless);

        switch (browserType.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                if (isHeadless) options.addArguments("--headless");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (isHeadless) edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new RuntimeException("Wrong browser type, choose between chrome,firefox, edge");
        }
        LOGGER.info("Navigating to URL {}", url);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIME_IN_SECOND));
    }

    public void quitBrowser() {
        if (driver != null) {
            LOGGER.info("Quitting the Browser");
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getProperties(String key){
        return properties.getProperty(key);
    }
}
