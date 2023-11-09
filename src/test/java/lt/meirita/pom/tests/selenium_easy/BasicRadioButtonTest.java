package lt.meirita.pom.tests.selenium_easy;

import lt.meirita.pom.pages.selenium_easy.BasicRadioButtonPage;
import lt.meirita.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BasicRadioButtonTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        BasicRadioButtonPage.openChrome("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
    }
    @DataProvider(name = "basicRadioButtonTest")
    public Object[][] provideDataButtonRadio() {
        return new Object[][]{
                {"Male", "Male"},
                {"Femaleee","Female"}


        };
    }

    @Test(dataProvider = "basicRadioButtonTest")
    public void testClickOnRadioButtons(String selectedValue,String actualResult){


        BasicRadioButtonPage.selectGender(selectedValue);
        BasicRadioButtonPage.clickOnButtonCheckedValue();
        actualResult = BasicRadioButtonPage.readMessageCheckedValue();

        Assert.assertTrue(
                actualResult.contains(selectedValue),
                "\nActual: %s, \nExpected: %s".formatted(
                        actualResult, selectedValue
                )
        );

    }
}
