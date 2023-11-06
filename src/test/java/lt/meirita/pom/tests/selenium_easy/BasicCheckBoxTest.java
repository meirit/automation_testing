package lt.meirita.pom.tests.selenium_easy;

import lt.meirita.pom.pages.selenium_easy.BasicCheckBoxPage;
import lt.meirita.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicCheckBoxTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp(){
        BasicCheckBoxPage.openChrome("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
    }
    @Test
    public void testClickOnCheckBox(){
        String expectedMessage ="Success - Check box is checked";
        String actualMessage;

        BasicCheckBoxPage.checkOnCheckBox();
        actualMessage= BasicCheckBoxPage.readSingleCheckBoxMessage();

        Assert.assertEquals(actualMessage, expectedMessage);
    }
    @Test
    public void testCheckBoxDefaultChecked(){
        boolean actualStatus;

        actualStatus = BasicCheckBoxPage.checkDefaultSelected();

        Assert.assertTrue(actualStatus);
    }
    @Test
    public void testCheckBoxDisabled(){
        boolean actualStatus;

        actualStatus = BasicCheckBoxPage.checkDefaultEnabled();

        Assert.assertFalse(actualStatus);

    }
}
