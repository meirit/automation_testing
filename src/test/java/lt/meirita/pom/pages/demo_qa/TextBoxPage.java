package lt.meirita.pom.pages.demo_qa;

import lt.meirita.pom.pages.Common;
import lt.meirita.pom.pages.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TextBoxPage {
    public static void openChrome(String url) {
        Common.setUpChrome();
        Common.openUrl(url);
    }

    public static void writeFullName(String userName) {
        Common.sendKeysToElement(
                Locator.DemoQa.TextBox.inputUserName,
                userName
        );
    }

    public static void writeEmail(String email) {
        Common.sendKeysToElement(
                Locator.DemoQa.TextBox.inputUserEmail,
                email
        );
    }

    public static void writeText(String attributeId, String text) {
        Common.sendKeysToElement(
                Locator.DemoQa.TextBox.setInputById(attributeId),
                text
        );
    }

    public static void clickOnButton() {
        Common.clickOnElement(Locator.DemoQa.TextBox.buttonSubmit);

    }

    public static String readUserName() {
        return Common.getTextFromElement(Locator.DemoQa.TextBox.paragraphName);
    }

    public static String readUserEmail() {
        return Common.getTextFromElement(Locator.DemoQa.TextBox.paragraphEmail);
    }

    public static String readResult(String attributeId) {
        return Common.getTextFromElement(Locator.DemoQa.TextBox.setParagraphById(attributeId)

        );
    }
}
