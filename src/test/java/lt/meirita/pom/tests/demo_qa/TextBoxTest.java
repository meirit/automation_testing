package lt.meirita.pom.tests.demo_qa;

import io.github.bonigarcia.wdm.WebDriverManager;
import lt.meirita.pom.pages.demo_qa.TextBoxPage;
import lt.meirita.pom.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextBoxTest extends TestBase {

    @BeforeMethod
    @Override
    public void setUp() {

        TextBoxPage.openChrome("https://demoqa.com/text-box");
    }

    @Test
    public void test() {
        String userName = "Vardenis Pavardenis";
        String email = "demo@demo.com";
        String expectedUserName = "Vardenis Pavardenis";
        String expectedEmail = "demo@demo.com";
        String actualUserName;
        String actualEmail;

//        WebElement inputfullName = driver.findElement(By.id("userName"));
        TextBoxPage.writeFullName(userName);
        TextBoxPage.writeEmail(email);
        TextBoxPage.clickOnButton();
        actualUserName = TextBoxPage.readUserName();
        actualEmail = TextBoxPage.readUserEmail();

        Assert.assertTrue(
                actualUserName.contains(expectedUserName),
                "\nActual: %s, \nExpected: 5s".formatted(actualUserName, expectedUserName)
        );

        Assert.assertTrue(
                actualEmail.contains(expectedEmail),
                "\nActual: %s, \nExpected: 5s".formatted(actualEmail, expectedEmail)
        );


    }

}
