package lt.meirita.dem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class WorkaroundZoomOut {

    @Test
    public void testScrollWithActions() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/text-box");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement inputFullName = driver.findElement(By.id("userName"));
        inputFullName.sendKeys("Vardenis Pavardenis");

        WebElement inputEmail = driver.findElement(By.id("userEmail"));
        inputEmail.sendKeys("demo@demo.com");

        WebElement buttonSubmit = driver.findElement(By.id("submit"));

        /**
         * Actions in order to scroll ana click on button
         */
        Actions actions = new Actions(driver);
        actions
//                .scrollToElement(buttonSubmit)
                .scrollByAmount(0, 500)
                .moveToElement(buttonSubmit)
                .click().build().perform();
    }

    @Test
    public void testScrollWithJavascriptExecutor() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/text-box");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement inputFullName = driver.findElement(By.id("userName"));
        inputFullName.sendKeys("Vardenis Pavardenis");

        WebElement inputEmail = driver.findElement(By.id("userEmail"));
        inputEmail.sendKeys("demo@demo.com");

        WebElement buttonSubmit = driver.findElement(By.id("submit"));

        /**
         * JavascriptExecutor to scroll down
         */
        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].scrollIntoView();", buttonSubmit);
        executor.executeScript("window.scrollBy(0,500)");

        buttonSubmit.click();
    }

    @Test
    public void testSetupDefaultZoomJavascriptExecutor() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);

        /**
         * JavascriptExecutor to set defaultZoom
         */
        driver.get("chrome://settings/");
        ((JavascriptExecutor) driver).executeScript("chrome.settingsPrivate.setDefaultZoom(0.5)");

        driver.get("https://demoqa.com/text-box");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement inputFullName = driver.findElement(By.id("userName"));
        inputFullName.sendKeys("Vardenis Pavardenis");

        WebElement inputEmail = driver.findElement(By.id("userEmail"));
        inputEmail.sendKeys("demo@demo.com");

        WebElement buttonSubmit = driver.findElement(By.id("submit"));
        buttonSubmit.click();
    }

    @Test
    public void testZoomAndClickWithJavascriptExecutor() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/text-box");

        /**
         * JavascriptExecutor zoom
         */
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.body.style.zoom = '70%'");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement inputFullName = driver.findElement(By.id("userName"));
        inputFullName.sendKeys("Vardenis Pavardenis");

        WebElement inputEmail = driver.findElement(By.id("userEmail"));
        inputEmail.sendKeys("demo@demo.com");

        WebElement buttonSubmit = driver.findElement(By.id("submit"));
//        buttonSubmit.click();

        /**
         * JavascriptExecutor to click
         */
        executor.executeScript("arguments[0].click();", buttonSubmit);
    }

}
