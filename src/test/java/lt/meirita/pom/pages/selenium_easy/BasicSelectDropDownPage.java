package lt.meirita.pom.pages.selenium_easy;

import lt.meirita.pom.pages.Common;
import lt.meirita.pom.pages.Locator;

public class BasicSelectDropDownPage {
    public static void openChrome(String url) {
        Common.setUpChrome();
        Common.openUrl(url);
    }

    public static void selectDayFromDropdownList(String selectValue) {
        Common.selectOptionByValue(
                Locator.SeleniumEasy.BasicSelectDropdown.selectDayOfWeek,
                selectValue
        );
    }

    public static String readMessageOfSingleDropdownList() {
        return Common.getTextFromElement(
                Locator.SeleniumEasy.BasicSelectDropdown.paragraphSelectedDay
        );
    }

    public static void selectStateFromDropdownList(String selectState) {
        Common.selectOptionByValue(
                Locator.SeleniumEasy.BasicSelectDropdown.selectState,
                selectState
        );
    }

    public static void selectStateArrayFromDropdownList(String[] selectStates) {
//        for (String state : selectStates) {
//            selectStateFromDropdownList(state);
//        }
        Common.multipleSelectWithActions(
                Locator.SeleniumEasy.BasicSelectDropdown.selectState,
                selectStates

        );
    }

    public static String readMessageOfMultipleDropdownList() {
        return Common.getTextFromElement(Locator.SeleniumEasy.BasicSelectDropdown.paragraphMultipleResults);
    }

    public static void clickOnButtonMultipleList() {
        Common.clickOnElement(Locator.SeleniumEasy.BasicSelectDropdown.buttonGetAllSelected);
    }
}
