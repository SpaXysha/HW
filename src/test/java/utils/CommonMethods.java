package utils;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class CommonMethods extends PageInitializers {
    public static WebDriver driver;

    public void openBrowserAndLaunchApplication() {
        switch ("chrome") {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(false);
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setHeadless(false);
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }
        driver.get("https://ctco.lv/en");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        initializePageObjects();
    }

    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }

    public static void waitForClickability(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }

    public static void tearDown() {
        driver.quit();
    }
}
