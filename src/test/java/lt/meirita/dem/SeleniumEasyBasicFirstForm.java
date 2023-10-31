package lt.meirita.dem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumEasyBasicFirstForm {

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();


        driver = new ChromeDriver(options);

//        driver.get("chrome://settings/");
//        ((JavascriptExecutor) driver).executeScript("chrome.settingsPrivate.setDefaultZoom(0.5)");

        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }



    @Test

    public void testSingleInputField(){

        String inputMessage = "Meirita Serdikauskaite";
        String expectedMessage = "Meirita Serdikauskaite";
        String actualMessage;



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
    @Test
    public void testPositiveTwoInputFieldsProviding9And13(){

        String value1 = "9";
        String value2 = "13";
        String actualTotal;
        String expectedTotal= "22";



        WebElement inputValue1 = driver.findElement(By.xpath("//input[@id='value1']"));
        inputValue1.sendKeys(value1);

        WebElement inputValue2 = driver.findElement(By.xpath("//input[@id='value2']"));
        inputValue2.sendKeys(value2);

        WebElement clickGetTotal = driver.findElement(By.xpath("//button[@onclick='return total()']"));
        clickGetTotal.click();

        WebElement displayTotal = driver.findElement(By.xpath("//span[@id='displayvalue']"));
        actualTotal = displayTotal.getText();

        Assert.assertTrue(
                actualTotal.contains(expectedTotal),
                "\nActual: %s, \nExpected: %s".formatted(actualTotal, expectedTotal)
        );

    }
    @Test
    public void testNegativeTwoInputFieldsProvidingAndSpace(){

    }
    @AfterMethod
    public void tearDown (){
        driver.quit();
    }

}
