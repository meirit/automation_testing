package lt.meirita.pom.pages.selenium_easy;

import lt.meirita.pom.pages.Common;
import lt.meirita.pom.pages.Locator;

public class BasicRadioButtonPage {
    public static void openChrome(String url) {
        Common.setUpChrome();
        Common.openUrl(url);
    }

    public static void selectGender(String selectedValue) {
        Common.clickOnElement(
                Locator.SeleniumEasy.BasicRadioButton.setGenderRadioButton(selectedValue)
        );
    }

    public static void clickOnButtonCheckedValue() {
        Common.clickOnElement(Locator.SeleniumEasy.BasicRadioButton.buttonGetValue);
    }

    public static String readMessageCheckedValue() {
        return Common.getTextFromElement(Locator.SeleniumEasy.BasicRadioButton.paragraphCheckedValue);
    }
}
