package lt.meirita.pom.tests.selenium_easy;

import lt.meirita.pom.pages.selenium_easy.BasicCheckBoxPage;
import lt.meirita.pom.tests.TestBase;
import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
    @DataProvider (name = "checkBoxSelection")
    public Object[][] provideDataCheckBoxGroup(){
        return new Object[][]{
                {true},
                {false}
        };
    }

    @Test (dataProvider = "checkBoxSelection")
    public void testAllCheckBoxesSelected(boolean expectedStatus ){

        boolean actualStatus;

        //expectedStatus == false

        if(!expectedStatus){
            BasicCheckBoxPage.clickOnButtonCheckAll();
        }

        BasicCheckBoxPage.clickOnButtonCheckAll();
        actualStatus = BasicCheckBoxPage.checkStatusesOfCheckBoxGroup(expectedStatus);

        Assert.assertTrue(actualStatus);
    }

//    @Test
//    public void testAllCheckBoxesIsNotSelected(){
//        boolean expectedStatus = false;
//        boolean actualStatus;
//
//        BasicCheckBoxPage.clickOnButtonCheckAll();
//        BasicCheckBoxPage.clickOnButtonCheckAll();
//        actualStatus = BasicCheckBoxPage.checkStatusesOfCheckBoxGroup(expectedStatus);
//
//        Assert.assertTrue(actualStatus);
//    }

    @DataProvider (name = "buttonAttributeValueCheck")
    public Object[][] provideValueNamesForCheckButton(){
        return new Object[][]{
                {"value", "Uncheck All"}

        };

    }

    @Test (dataProvider = "buttonAttributeValueCheck")
    public void testAttributeChangeOnButtonClickValue(String attributeName, String expectedAttributeValue){
        String actualAttributeValue;

        BasicCheckBoxPage.clickOnButtonCheckAll();
        actualAttributeValue = BasicCheckBoxPage.getButtonAttributeValue(attributeName);

        Assert.assertEquals(actualAttributeValue, expectedAttributeValue);



    }

//    @Test
//    public void testAttributeChangeOnButtonClickValueIsCheckAll(){
//        String attributeName ="value";
//        String expectedAttributeValue = "Check All";
//        String actualAttributeValue;
//
//        BasicCheckBoxPage.clickOnButtonCheckAll();
//        BasicCheckBoxPage.clickOnButtonCheckAll();
//
//        actualAttributeValue = BasicCheckBoxPage.getButtonAttributeValue(attributeName);
//
//        Assert.assertEquals(actualAttributeValue, expectedAttributeValue);
//
//
//
//    }


}
