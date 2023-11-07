package lt.meirita.pom.pages.selenium_easy;

import lt.meirita.pom.pages.Common;
import lt.meirita.pom.pages.Locator;
import org.openqa.selenium.By;

import java.util.List;

public class BasicCheckBoxPage {
    public static void openChrome(String url) {
        Common.setUpChrome();
        Common.openUrl(url);
    }

    public static void checkOnCheckBox() {
        Common.clickOnElement(Locator.SeleniumEasy.BasicCheckBox.inputIsAgeSelected);
    }

    public static String readSingleCheckBoxMessage() {
        return Common.getTextFromElement(Locator.SeleniumEasy.BasicCheckBox.divTxtAge);
    }

    public static boolean checkDefaultSelected() {
        return Common.isElementSelected(
                Locator.SeleniumEasy.BasicCheckBox.CheckBoxDefaultSelected

        );
    }

    public static boolean checkDefaultEnabled() {
        return Common.isElementEnabled(
                Locator.SeleniumEasy.BasicCheckBox.CheckBoxDefaultEnabled);
    }

    public static void clickOnButtonCheckAll() {
        Common.clickOnElement(Locator.SeleniumEasy.BasicCheckBox.buttonCheckAll);
    }

    public static boolean checkStatusesOfCheckBoxGroup(boolean expectedStatus) {
        List<Boolean> statuses = Common.getStatusesOfElements(Locator.SeleniumEasy.BasicCheckBox.checkBoxMultiple);

        for (Boolean status : statuses) {
            if(status != expectedStatus) return false;
        }

        return true;

    }

    public static String getButtonAttributeValue(String attributeName) {
        return Common.getElementAttributeValue(Locator.SeleniumEasy.BasicCheckBox.buttonCheckAll,
                attributeName
        );
    }
}
