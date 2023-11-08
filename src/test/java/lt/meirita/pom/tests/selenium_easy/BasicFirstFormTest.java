package lt.meirita.pom.tests.selenium_easy;

import io.github.bonigarcia.wdm.WebDriverManager;
import lt.meirita.pom.pages.selenium_easy.BasicFirstFromPage;
import lt.meirita.pom.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasicFirstFormTest extends TestBase {


    @BeforeMethod
    @Override
    public void setUp() {

        BasicFirstFromPage.openChrome("https://demo.seleniumeasy.com/basic-first-form-demo.html");
    }

    @Test

    public void testSingleInputField() {

        String text = "Meirita Serdikauskaite";
        String expectedText = "Meirita Serdikauskaite";
        String actualText;


        BasicFirstFromPage.writeUserMessage(text);
        BasicFirstFromPage.clickOnButtonShowMessage();
        actualText = BasicFirstFromPage.readUserMessage();


        Assert.assertTrue(
                actualText.contains(expectedText),
                "\nActual: %s, \nExpected: %s".formatted(actualText, expectedText)
        );


    }

    @DataProvider(name ="twoInputFields")
    public Object[][] provideDataForTwoInputFields(){
        return new Object[][]{
                {"9", "13", "22"},
                {"92","18", "110"},
                {"0", "0", "0"},
                {" ", "2", "NaN"},
                {"-5", "asdf", "NaN"},
                {" ", " ", "NaN"},
        };
    }

    @Test(dataProvider = "twoInputFields")
    public void testTwoInputFields(String value1,String value2, String expectedTotal ) {

        String actualTotal;




        BasicFirstFromPage.enterValue("value1", value1);
        BasicFirstFromPage.enterValue("value2", value2);
        BasicFirstFromPage.clickOnButtonGetTotal();
        actualTotal = BasicFirstFromPage.readMessageTotal();

//        Assert.assertTrue(
//                actualTotal.contains(expectedTotal),
//                "\nActual: %s, \nExpected: %s".formatted(actualTotal, expectedTotal)
//        );

        Assert.assertEquals(actualTotal, expectedTotal);

    }

    @Test
    public void testNegativeTwoInputFieldsProvidingAndSpace() {

    }

}


