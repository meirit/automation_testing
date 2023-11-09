package lt.meirita.pom.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
//    private static WebDriver driver
    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static void setChromeDriver() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");

//        driver = new ChromeDriver(options);

        drivers.set(new ChromeDriver(options));

        drivers.get().get("chrome://settings/");
        ((JavascriptExecutor) drivers.get()).executeScript("chrome.settingsPrivate.setDefaultZoom(0.7)");

//        drivers.get().manage().timeouts().implicitlyWait(8);
    }
    public static void setSafariDriver() {
        WebDriverManager.safaridriver().setup();
        drivers.set(new SafariDriver());
    }

    public static WebDriver getDriver() {

//        return driver;

        return drivers.get();
    }

    public static void quitDriver(){

//        driver.quit();
        drivers.get().quit();
        drivers.remove();
    }

}
