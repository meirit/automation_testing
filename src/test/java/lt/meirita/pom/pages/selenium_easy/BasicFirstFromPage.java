package lt.meirita.pom.pages.selenium_easy;

import lt.meirita.pom.pages.Common;
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
                By.xpath("//input[@id='user-message']"),
                text
        );
    }

    public static void clickOnButtonShowMessage() {

        Common.clickOnElement(By.xpath("//button[@onclick='showInput();']"));

    }

    public static String readUserMessage() {
        return Common.getTextFromElement(By.xpath("//div[@id='user-message']//span"));
    }
}
