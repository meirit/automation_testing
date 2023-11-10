package lt.meirita.pom.tests.selenium_easy;

import lt.meirita.pom.pages.selenium_easy.JavaScriptAlertBoxPage;
import lt.meirita.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JavaScriptAlertBoxTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        JavaScriptAlertBoxPage.openChrome("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");

    }



    @Test
    public void testAlertBox() {
        String expectedResult = "I am an alert box!";
        String actualResult = "";

        JavaScriptAlertBoxPage.clickOnButtonOpenAlertBox();
        actualResult = JavaScriptAlertBoxPage.readMessageFromAlertBox();
        JavaScriptAlertBoxPage.clickOkOnAlertBox();


        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
        public void testPromptBox() {
            String expectedResult = "Meirita";
            String actualResult = "";
            String message = "Meirita";

            JavaScriptAlertBoxPage.clickOnButtonOpenPromptBox();
            JavaScriptAlertBoxPage.writeMessageIntoAlertBox(message);
            JavaScriptAlertBoxPage.clickOkOnAlertBox();
            actualResult = JavaScriptAlertBoxPage.readMessagePromptBox();

            Assert.assertTrue(
                    actualResult.contains(expectedResult),
                    "\nActual: %s, \nExpected: %s".formatted(
                            actualResult, expectedResult
                    )
            );
        }
}
