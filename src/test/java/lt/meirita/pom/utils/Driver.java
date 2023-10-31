package lt.meirita.pom.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
    private static WebDriver driver;

    public static void setChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    public static void setSafariDriver() {
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver(){
        driver.quit();
    }

}
