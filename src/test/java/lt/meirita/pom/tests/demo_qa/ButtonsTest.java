package lt.meirita.pom.tests.demo_qa;

import lt.meirita.pom.pages.demo_qa.ButtonsPage;
import lt.meirita.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ButtonsTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        ButtonsPage.openChrome("https://demoqa.com/buttons");
    }

    @DataProvider(name = "dataProviderName")
    public Object[][] provideData() {
        return new Object[][]{
                {},
                {}
        };
    }

    @Test
    public void testButtonDoubleClick() {
        String expectedResult = "double click";
        String actualResult = "";

        ButtonsPage.doubleClickOnButton();
        actualResult = ButtonsPage.readMessageDoubleClick();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s, \nExpected: %s".formatted(
                        actualResult, expectedResult
                )
        );
    }

    @Test
    public void testButtonRightClick() {
        String expectedResult = "right click";
        String actualResult = "";

        ButtonsPage.rightClickonButton();
        actualResult = ButtonsPage.readMessageRightClick();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s, \nExpected: %s".formatted(
                        actualResult, expectedResult
                )
        );
    }
}
