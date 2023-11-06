package lt.meirita.pom.pages.sauce_demo;

import lt.meirita.pom.pages.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SauceDemoPage {
    public static void openChrome(String url) {
        Common.setUpChrome();
        Common.openUrl(url);
    }

    public static void writeUserName(String userName) {
        Common.sendKeysToElement(
                By.xpath("//input[@id='user-name']"),
                userName
        );
    }

    public static void writePassword(String password) {
        Common.sendKeysToElement(
                By.xpath("//input[@id='password']"),
                password
        );

    }

    public static void clickOnButtonLogin() {
        Common.clickOnElement(By.xpath("//input[@id='login-button']"));
    }

    public static String getMessage() {
        Common.getTextFromElement(By.xpath("//div[text()='Swag Labs' and @class='app_logo']"));
        return null;
    }

    public static void closeDriver() {
        Common.quitDriver();
    }
}
