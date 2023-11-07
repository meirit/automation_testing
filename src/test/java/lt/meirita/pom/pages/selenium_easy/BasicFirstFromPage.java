package lt.meirita.pom.pages.selenium_easy;

import lt.meirita.pom.pages.Common;
import lt.meirita.pom.pages.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasicFirstFromPage {
    public static void openChrome(String url) {
        Common.setUpChrome();
        Common.openUrl(url);
    }

    public static void closeDriver() {
        Common.quitDriver();
    }

    public static void writeUserMessage(String text) {

        Common.sendKeysToElement(
                Locator.SeleniumEasy.BasicFirstForm.inputUserMessage,
                text
        );
    }

    public static void clickOnButtonShowMessage() {

        Common.clickOnElement(Locator.SeleniumEasy.BasicFirstForm.buttonShowMessage);


    }

    public static String readUserMessage() {
        return Common.getTextFromElement(Locator.SeleniumEasy.BasicFirstForm.readUserMessage);
    }

    public static void enterValue(String attributeId, String value) {
        Common.sendKeysToElement(Locator.SeleniumEasy.BasicFirstForm.setValueById(attributeId),
                value

        );
    }

    public static void clickOnButtonGetTotal() {
        Common.clickOnElement(Locator.SeleniumEasy.BasicFirstForm.buttonGetTotal);
    }

    public static String readMessageTotal() {
        return Common.getTextFromElement(Locator.SeleniumEasy.BasicFirstForm.displayValue);
    }
}
