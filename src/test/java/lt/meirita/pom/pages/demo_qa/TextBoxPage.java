package lt.meirita.pom.pages.demo_qa;

import lt.meirita.pom.pages.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TextBoxPage {
    public static void openChrome(String url) {
        Common.setUpChrome();
        Common.openUrl(url);
    }

    public static void writeFullName(String userName) {
        Common.sendKeysToElement(
                By.xpath("//input[@id='userName']"),
                userName
        );
    }

    public static void writeEmail(String email) {
        Common.sendKeysToElement(
                By.xpath("//input[@id='userEmail']"),
                email
        );
    }

    public static void clickOnButton() {
        Common.clickOnElement(By.xpath("//button[@id='submit']"));
    }

    public static String readUserName() {
        return Common.getTextFromElement(By.xpath("//p[@id='name']"));
    }

    public static String readUserEmail() {
        return Common.getTextFromElement(By.xpath("//p[@id='email']"));
    }
}
