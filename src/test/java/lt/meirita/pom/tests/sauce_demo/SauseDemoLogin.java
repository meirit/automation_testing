package lt.meirita.pom.tests.sauce_demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import lt.meirita.pom.pages.sauce_demo.SauceDemoPage;
import lt.meirita.pom.pages.selenium_easy.BasicFirstFromPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SauceDemoLogin1 {

    @BeforeMethod
    public void setUp(){

        SauceDemoPage.openChrome("https://www.saucedemo.com/");

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @Test
    public void testingLoginSimpleUser(){
        String userName = "standard_user";
        String password ="secret_sauce";
        String expectedText="Swag Labs";
        String actualText;


        SauceDemoPage.writeUserName(userName);
        SauceDemoPage.writePassword(password);
        SauceDemoPage.clickOnButtonLogin();
        actualText = SauceDemoPage.getMessage();







//        WebElement divSvagLab = driver.findElement(By.xpath("//div[text()='Swag Labs' and @class='app_logo']"));

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
//        wait.until(ExpectedConditions.visibilityOf(divSvagLab));

//        actualText = divSvagLab.getText();

        Assert.assertEquals(actualText, expectedText);


    }

    @AfterMethod
    public void tearDown() {
        SauceDemoPage.closeDriver();
    }


}
