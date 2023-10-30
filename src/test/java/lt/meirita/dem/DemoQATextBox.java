package lt.meirita.dem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoQATextBox {
    String userName= "Vardenis Pavardenis";
    String email = "demo@demo.com";
    String expectedUserName = "Vardenis Pavardenis";
    String expectedEmail= "demo@demo.com";
    String actualUserName;
    String actualEmail;



    @Test
    public void test(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--force-device-scale-factor=0.75");
//        options.addArguments("--start-fullscreen");
//        options.addArguments("--headless=new");
//        options.addArguments("--window-size=1400,600");

        WebDriver driver = new ChromeDriver(options);

        driver.get("chrome://settings/");
        ((JavascriptExecutor) driver).executeScript("chrome.settingsPrivate.setDefaultZoom(0.5)");

        driver.get("https://demoqa.com/text-box");
//        driver.manage().window().maximize();
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("document.body.style.zoom = '0.75'");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        WebElement inputfullName = driver.findElement(By.id("userName"));
        WebElement inputfullName = driver.findElement(By.xpath("//input[@id='userName']"));
        inputfullName.sendKeys(userName);

//        WebElement inputEmail = driver.findElement(By.id("userEmail"));
        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        inputEmail.sendKeys(email);

//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        WebElement submitButton = driver.findElement(By.id("submit"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();

//        WebElement pargraphUserName = driver.findElement(By.id("name"));
        WebElement pargraphUserName = driver.findElement(By.xpath("//p[@id='name']"));
        actualUserName = pargraphUserName.getText();

        WebElement paragraphUserEmail = driver.findElement(By.xpath("//p[@id='email']"));
        actualEmail = paragraphUserEmail.getText();

        Assert.assertTrue(
                actualUserName.contains(expectedUserName),
                "\nActual: %s, \nExpected: 5s".formatted(actualUserName, expectedUserName)
        );

        Assert.assertTrue(
                actualEmail.contains(expectedEmail),
                "\nActual: %s, \nExpected: 5s".formatted(actualEmail, expectedEmail)
        );

        driver.quit();

//        Actions actions = new Actions(driver);
//        actions.moveToElement(element).click().build().perform();

    }
}
