package lt.meirita.pom.tests.selenium_easy;

import lt.meirita.pom.pages.selenium_easy.BasicSelectDropDownPage;
import lt.meirita.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BasicSelectDropDownTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        BasicSelectDropDownPage.openChrome("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");

    }

    @DataProvider(name = "singleDropDownList")
    public Object[][] provideDataSingleDropdownList() {
        return new Object[][]{
                {"Monday", "Monday"},
                {"Tuesday", "Tuesday"},
                {"Wednesday", "Wednesday"},
                {"Thursday", "Thursday"},
                {"Friday", "Friday"},
                {"Saturday", "Saturday"},
                {"Sunday", "Sunday"}
        };
    }

    @Test(dataProvider = "singleDropDownList")
    public void testSingleDropdownList(
            String selectValue, String expectedResult
    ) {
        String actualResult;

        BasicSelectDropDownPage.selectDayFromDropdownList(selectValue);

        actualResult = BasicSelectDropDownPage.readMessageOfSingleDropdownList();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s, \nExpected: %s".formatted(
                        actualResult, expectedResult
                )
        );

    }

    @DataProvider(name = "multipleDropDownList")
    public Object[][] provideDataMultipleDropdownList() {
        return new Object[][]{
                {"Florida", "Texas", "New Jersey"},
                {"California", "Ohio"},
                {"Pennsylvania", "Washington","New York","Texas"},

        };
    }
    @Test(dataProvider = "multipleDropDownList")
    public void testMultipleDropdownList(String[] states){

            String actualResult;

        BasicSelectDropDownPage.selectStateArrayFromDropdownList(states);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        actualResult = BasicSelectDropDownPage.readMessageOfSingleDropdownList();

//        Assert.assertTrue(
//                actualResult.contains(expectedResult),
//                "\nActual: %s, \nExpected: %s".formatted(
//                        actualResult, expectedResult
//                )
//        );

    }
}


