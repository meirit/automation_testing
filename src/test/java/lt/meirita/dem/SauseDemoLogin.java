package lt.meirita.dem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SauseDemoLogin {

    @Test
    public void testingLoginSimpleUser(){
        String userName = "standard_user";
        String password ="secret_sauce";
        String expectedText="Swag Labs";
        String actualText;

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();


        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");

        WebElement inputUserName = driver.findElement(By.xpath("//input[@id='user-name']"));
        inputUserName.sendKeys(userName);

        WebElement inputPassword =driver.findElement(By.xpath("//input[@id='password']"));
        inputPassword.sendKeys(password);

        WebElement buttonLogin = driver.findElement(By.xpath("//input[@id='login-button']"));
        buttonLogin.click();



        WebElement divSvagLab = driver.findElement(By.xpath("//div[text()='Swag Labs' and @class='app_logo']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOf(divSvagLab));

        actualText = divSvagLab.getText();

        Assert.assertEquals(actualText, expectedText);
        driver.quit();



    }


}
