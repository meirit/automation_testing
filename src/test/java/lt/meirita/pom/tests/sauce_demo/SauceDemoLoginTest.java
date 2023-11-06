package lt.meirita.pom.tests.sauce_demo;

import lt.meirita.pom.pages.sauce_demo.SauceDemoPage;
import lt.meirita.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceDemoLoginTest extends TestBase {

    @BeforeMethod
    @Override
    public void setUp(){

        SauceDemoPage.openChrome("https://www.saucedemo.com/");

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @Test
    public void testingLoginSimpleUser(){
        String userName = "standard_user";
        String password ="secret_sauce";
        String expectedText= "Swag Labs";
        String actualText;


        SauceDemoPage.writeUserName(userName);
        SauceDemoPage.writePassword(password);
        SauceDemoPage.clickOnButtonLogin();
        actualText = SauceDemoPage.getMessage();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
//        wait.until(ExpectedConditions.visibilityOf(divSvagLab));

        Assert.assertEquals(actualText, expectedText);


    }




}
