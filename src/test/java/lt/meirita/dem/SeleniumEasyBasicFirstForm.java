package lt.meirita.dem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumEasyBasicFirstForm {

    String inputMessage = "Meirita Serdikauskaite";
    String expectedMessage = "Meirita Serdikauskaite";
    String actualMessage;

    @Test

    public void testSingleInputField(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();


        WebDriver driver = new ChromeDriver(options);

//        driver.get("chrome://settings/");
//        ((JavascriptExecutor) driver).executeScript("chrome.settingsPrivate.setDefaultZoom(0.5)");

        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        WebElement inputUserMessage = driver.findElement(By.id("user-message"));
        WebElement inputUserMessage = driver.findElement(By.xpath("//input[@id='user-message']"));
        inputUserMessage.sendKeys(inputMessage);

//        WebElement showMesssage =driver.findElement(By.className("btn-primary"));
        WebElement showMesssage =driver.findElement(By.xpath("//button[@onclick='showInput();']"));
        showMesssage.click();

//        WebElement displayMessage = driver.findElement(By.id("display"));
        WebElement displayMessage = driver.findElement(By.xpath("//div[@id='user-message']//span"));
        actualMessage = displayMessage.getText();

        Assert.assertTrue(
                actualMessage.contains(expectedMessage),
                "\nActual: %s, \nExpected: %s".formatted(actualMessage, expectedMessage)
        );




    }

}
