package lt.meirita.pom.pages.selenium_easy;

import lt.meirita.pom.pages.Common;
import lt.meirita.pom.pages.Locator;

public class JavaScriptAlertBoxPage {
    public static void openChrome(String url) {
        Common.setUpChrome();
        Common.openUrl(url);
    }

    public static void clickOnButtonOpenAlertBox() {
        Common.clickOnElement(Locator.SeleniumEasy.JavaScriptAlertBox.buttonOpenAlertBox);
    }

    public static void clickOkOnAlertBox() {

        Common.acceptAlert();
    }



    public static String readMessageFromAlertBox() {
        return Common.getTextFromAlertBox();
    }

    public static void clickOnButtonOpenPromptBox() {
        Common.clickOnElement(Locator.SeleniumEasy.JavaScriptAlertBox.buttonOpenPromtBox);
    }

    public static void writeMessageIntoAlertBox(String message) {
        Common.sendKeysToAlert(message);
    }

    public static String readMessagePromptBox() {
        return Common.getTextFromElement(Locator.SeleniumEasy.JavaScriptAlertBox.paragraphPromptBox);
    }
}
